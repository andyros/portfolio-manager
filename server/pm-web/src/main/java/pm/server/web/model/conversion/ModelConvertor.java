package pm.server.web.model.conversion;

import java.util.Collection;
import java.util.List;

import pm.server.persistence.entity.AbstractEntity;

public interface ModelConvertor {

    <T> T convert(Object source, Class<T> destinationClass);

    <T> List<T> convert(Collection<?> source, Class<T> destinationClass);

    <M, E extends AbstractEntity> M entityToModel(E entity, Class<M> modelClass);

    <M, E extends AbstractEntity> List<M> entityToModel(Collection<E> entities, Class<M> modelClass);
}
