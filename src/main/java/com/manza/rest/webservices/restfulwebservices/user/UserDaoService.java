package com.manza.rest.webservices.restfulwebservices.user;

import com.manza.rest.webservices.restfulwebservices.post.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static List<Post> posts1 = new ArrayList<>();
    private static List<Post> posts2 = new ArrayList<>();
    private static List<Post> posts3 = new ArrayList<>();

    private static int usersCount = 3;
    private static int postsCount = 3;

    static {
        Post post1 = new Post(1, "Meu primeiro post", new Date());
        Post post2 = new Post(2, "Post 2", new Date());
        Post post3 = new Post(3, "Post 3", new Date());

        posts1.add(post1);
        posts1.add(post2);
        posts1.add(post3);

        posts2.add(post1);
        posts2.add(post2);

        posts3.add(post3);

        users.add(new User(1, "Adam", new Date(), posts1));
        users.add(new User(2, "Jord", new Date(), posts2));
        users.add(new User(3, "Manz", new Date(), posts3));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for(User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteUser(int id) {
        for(User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                --usersCount;
                return user;
            }
        }
        return null;
    }

    public List<Post> findAllPostsByUser(int userId) {
        for(User user : users) {
            if (user.getId() == userId) {
                return user.getPosts();
            }
        }
        return null;
    }

    public Post savePost(int userId, Post post) {
        if (post.getId() == null) {
            post.setId(++postsCount);
        }

        for(User user : users) {
            if (user.getId() == userId) {
                user.getPosts().add(post);
                break;
            }
        }

        return post;
    }

    public Post retrievePost(int userId, int postId) {
        for(User user : users) {
            if (user.getId() == userId) {
                for(Post post : user.getPosts()) {
                    if (post.getId() == postId) {
                        return post;
                    }
                }
            }
        }

        return null;
    }

}