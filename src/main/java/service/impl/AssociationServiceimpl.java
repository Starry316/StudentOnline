package service.impl;

import dao.IAssociationDao;
import entity.AssociationEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import service.IAssociationService;

import javax.annotation.Resource;

/**
 * Created by Starry on 2017/12/11.
 */
@Transactional
@Repository("associationService")
public class AssociationServiceimpl extends BaseServiceimpl<AssociationEntity,Long> implements IAssociationService {
    @Resource(name = "associationDao")
    IAssociationDao associationDao;
    @Override
    @Transactional
    public long createAssociation(AssociationEntity associationEntity) {
        return associationDao.insert(associationEntity);
    }

}
