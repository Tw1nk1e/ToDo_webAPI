package com.coxautodev.graphql.tools.example.resolvers;

        import com.coxautodev.graphql.tools.GraphQLQueryResolver;
        import com.coxautodev.graphql.tools.example.repositories.CategoriesRepositories;
        import com.coxautodev.graphql.tools.example.repositories.TasksRepositories;
        import com.coxautodev.graphql.tools.example.models.*;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

        import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private TasksRepositories tasksRepository;
    private CategoriesRepositories categoriesRepositories;

    @Autowired
    public Query(TasksRepositories tasksRepository, CategoriesRepositories categoriesRepositories) {
        this.categoriesRepositories = categoriesRepositories;
        this.tasksRepository = tasksRepository;
    }

    public List<Task> getTasks() {
        return tasksRepository.findAll();
    }

    public List<Task> getTasksByCategory(String id) {
        return tasksRepository.findAllByCategory(id);
    }

    public List<Category> getCategories() {
        return categoriesRepositories.findAll();
    }
}
