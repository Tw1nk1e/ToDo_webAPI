package com.coxautodev.graphql.tools.example.resolvers;

        import com.coxautodev.graphql.tools.GraphQLMutationResolver;
        import com.coxautodev.graphql.tools.example.models.Statuses;
        import com.coxautodev.graphql.tools.example.repositories.TasksRepositories;
        import com.coxautodev.graphql.tools.example.models.Task;
        import org.bson.types.ObjectId;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private TasksRepositories repository;

    public Task addTask(String desc) {
        return repository.save(new Task(desc));
    }

    public Boolean deleteTask(ObjectId id) {
        repository.deleteById(id);
        return true;
    }

    public Boolean changeTaskStatus(ObjectId id) {
        Task task = repository.findById(id).get();

        if (task.getStatus() == Statuses.UNDONE) {
            task.setStatus(Statuses.DONE);
        } else {
            task.setStatus(Statuses.UNDONE);
        }
        repository.save(task);
        return true;
    }
}
