package ${PACKAGE_NAME};
#set($LOWER_NAME=${NAME.substring(0,1).toLowerCase()}+${NAME.substring(1).toLowerCase()})
import me.binf.core.Constant;
import me.binf.dao.${NAME}Dao;
import me.binf.entity.${NAME};
import me.binf.service.${NAME}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by wangbin on 14-10-16.
 */
@Service
@Transactional(readOnly = true)
public class ${NAME}ServiceImpl implements ${NAME}Service {

    @Autowired
    private ${NAME}Dao ${LOWER_NAME}Dao;


    @Override
    public List<${NAME}> findAll() {
        return ${LOWER_NAME}Dao.findAll();
    }

    @Override
    public Page<${NAME}> find(int pageNum, int pageSize) {
        return ${LOWER_NAME}Dao.findAll(new PageRequest(pageNum,pageSize, Sort.Direction.DESC,"id"));
    }

    @Override
    public Page<${NAME}> find(int pageNum) {
        return find(pageNum, Constant.PAGE_DEF_SZIE);
    }

    @Override
    public ${NAME} getById(int id) {
        return ${LOWER_NAME}Dao.findOne(id);
    }

    @Override
    @Transactional
    public ${NAME} deleteById(int id) {
        ${NAME} ${LOWER_NAME} = getById(id);
        ${LOWER_NAME}Dao.delete(${LOWER_NAME});
        return ${LOWER_NAME};
    }

    @Override
    @Transactional
    public ${NAME} create(${NAME} ${LOWER_NAME}) {
        ${LOWER_NAME}.setCreateDate(new Date());
        return save(${LOWER_NAME});
    }

    @Override
    @Transactional
    public ${NAME} update(${NAME} ${LOWER_NAME}) {
        ${LOWER_NAME}.setUpdateDate(new Date());
        return save(${LOWER_NAME});
    }

    @Transactional
    public ${NAME} save(${NAME} ${LOWER_NAME}) {
        return ${LOWER_NAME}Dao.save(${LOWER_NAME});
    }
}
