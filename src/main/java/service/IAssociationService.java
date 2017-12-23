package service;

import entity.AssociationEntity;

/**
 * Created by Starry on 2017/12/11.
 */
public interface IAssociationService {
    /**
     * 创建社团
     * @param associationEntity
     * @return 新社团id
     */
    long createAssociation(AssociationEntity associationEntity);
}
