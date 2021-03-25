package turntabl.io.RqueuePublisher.repository;


import org.springframework.data.repository.CrudRepository;
import turntabl.io.RqueuePublisher.model.MenuModel;

public interface RqueuePublisherRepo extends CrudRepository<MenuModel, Long> {
}
