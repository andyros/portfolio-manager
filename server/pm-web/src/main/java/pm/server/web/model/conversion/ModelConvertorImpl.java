package pm.server.web.model.conversion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.Mapper;

import pm.server.persistence.entity.AbstractEntity;

public class ModelConvertorImpl implements ModelConvertor {

    @Resource
    private Mapper dozerMapper;

    @Override
    public <M, E extends AbstractEntity> M entityToModel(E entity, Class<M> modelClass) {
        if (entity == null) {
            return null;
        }
        return this.dozerMapper.map(entity, modelClass);
    }

    @Override
    public <M, E extends AbstractEntity> List<M> entityToModel(Collection<E> entities,
            Class<M> modelClass) {
        return mapAll(entities, modelClass);
    }

    private <T> List<T> mapAll(Collection<?> objects, Class<T> destinationClass) {
        List<T> all = new ArrayList<T>(objects.size());
        for (Object o : objects) {
            all.add(this.dozerMapper.map(o, destinationClass));
        }
        return all;
    }
}
