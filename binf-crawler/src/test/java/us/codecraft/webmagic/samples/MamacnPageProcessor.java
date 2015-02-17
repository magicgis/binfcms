package us.codecraft.webmagic.samples;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.samples.pipeline.OneFilePipeline;
import us.codecraft.webmagic.scheduler.FileCacheQueueScheduler;
import us.codecraft.webmagic.selector.Selectable;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author code4crafer@gmail.com
 */
public class MamacnPageProcessor implements PageProcessor {

    private Site site = Site.me().setDomain("www.meipai.com").setSleepTime(100);

    @Override
    public void process(Page page) {
        List<Selectable> nodes = page.getHtml().xpath("//ul[@id=mediasList]/li").nodes();
        StringBuilder accum = new StringBuilder();
        String exp  = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D\\w].*";

        for (Selectable node : nodes) {
            String title = node.xpath("//img/@alt").get();
            Pattern pattern = Pattern.compile(exp);
            boolean tf =  pattern.matcher(title).matches();
            if(!tf){
              continue;
            }
            accum.append("INSERT INTO video (url,title,username,picture) VALUES (");
            accum.append("\'"+node.xpath("//div/@data-video").get()).append("\',");
            accum.append("\'"+title).append("\',");
            accum.append("\'美拍\',");
            accum.append("\'"+node.xpath("//img/@src").get()).append("\'");
            accum.append(");");
            accum.append("\n");

        }
        page.putField("",accum.toString());
        if (accum.length() == 0) {
            page.setSkip(true);
        }
        page.addTargetRequests(page.getHtml().links().regex("http://www\\.meipai\\.com/square/.*").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Spider.create(new MamacnPageProcessor())
                .setScheduler(new FileCacheQueueScheduler("E:/webmagic/mamacn"))
                .addUrl("http://www.meipai.com/")
                .addPipeline(new OneFilePipeline("E:/webmagic/mamacn/data.sql"))
                .thread(5)
                .run();
    }
}
