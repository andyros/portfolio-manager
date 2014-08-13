package pm.server.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pm.server.persistence.entity.AbstractEntity;
import pm.server.web.model.conversion.ModelConvertor;

public abstract class AbstractController<E extends AbstractEntity, M> {

    @Resource
    protected ModelConvertor modelConvertor;

    private Class<E> entityClass;
    private Class<M> modelClass;

    public AbstractController(Class<E> entityClass, Class<M> modelClass) {
        super();
        this.entityClass = entityClass;
        this.modelClass = modelClass;
    }

    @RequestMapping("/")
    public List<M> findAll() {
        List<E> all = getRepository().findAll();
        return this.modelConvertor.entityToModel(all, this.modelClass);
    }

    @RequestMapping("/{id}")
    public M getById(@PathVariable Long id) {
        E e = getRepository().findOne(id);
        return this.modelConvertor.entityToModel(e, this.modelClass);
    }

    protected abstract JpaRepository<E, Long> getRepository();
}
