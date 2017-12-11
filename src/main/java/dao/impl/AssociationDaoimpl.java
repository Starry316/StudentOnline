package dao.impl;

import dao.IAssociationDao;
import entity.AssociationEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Starry on 2017/12/11.
 */
@Repository("associationDao")
public class AssociationDaoimpl extends BaseDaoimpl<AssociationEntity,Long> implements IAssociationDao{
    @Override
    @Transactional
    public long insert(AssociationEntity associationEntity) {
        return super.save(associationEntity);
    }
}
