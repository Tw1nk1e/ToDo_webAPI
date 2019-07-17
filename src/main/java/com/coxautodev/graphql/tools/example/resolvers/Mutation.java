package com.coxautodev.graphql.tools.example.resolvers;

        import com.coxautodev.graphql.tools.GraphQLMutationResolver;
        import com.coxautodev.graphql.tools.example.models.Category;
        import com.coxautodev.graphql.tools.example.models.Statuses;
        import com.coxautodev.graphql.tools.example.repositories.CategoriesRepositories;
        import com.coxautodev.graphql.tools.example.repositories.TasksRepositories;
        import com.coxautodev.graphql.tools.example.models.Task;
        import org.bson.types.ObjectId;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

        import java.util.List;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private TasksRepositories taskRepository;
    @Autowired
    private CategoriesRepositories categoriesRepository;

    public Task addTask(String desc, String category) {
        return taskRepository.save(new Task(desc, category));
    }

    public Category addCategory(String name) {
        return categoriesRepository.save(new Category(name));
    }

    public Boolean deleteCategory(ObjectId id) {
        List<Task> tasksList = this.taskRepository.findAllByCategory(id.toString());
        tasksList.forEach(task -> taskRepository.deleteById(new ObjectId(task.getId())));
        categoriesRepository.deleteById(id);
        return true;
    }

    public Boolean deleteTask(ObjectId id) {
        taskRepository.deleteById(id);
        return true;
    }

    public Boolean changeTaskStatus(ObjectId id) {
        Task task = taskRepository.findById(id).get();

        if (task.getStatus() == Statuses.UNDONE) {
            task.setStatus(Statuses.DONE);
        } else {
            task.setStatus(Statuses.UNDONE);
        }
        taskRepository.save(task);
        return true;
    }
}
