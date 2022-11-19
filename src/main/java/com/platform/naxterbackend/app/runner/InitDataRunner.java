package com.platform.naxterbackend.app.runner;

import com.platform.naxterbackend.merchandising.model.Item;
import com.platform.naxterbackend.merchandising.repository.ItemRepository;
import com.platform.naxterbackend.merchandising.model.Merchandising;
import com.platform.naxterbackend.merchandising.repository.MerchandisingRepository;
import com.platform.naxterbackend.post.model.Post;
import com.platform.naxterbackend.post.repository.PostRepository;
import com.platform.naxterbackend.profile.model.Profile;
import com.platform.naxterbackend.profile.repository.ProfileRepository;
import com.platform.naxterbackend.subscription.model.Subscription;
import com.platform.naxterbackend.subscription.repository.SubscriptionRepository;
import com.platform.naxterbackend.user.model.Role;
import com.platform.naxterbackend.user.model.RoleEnum;
import com.platform.naxterbackend.user.repository.RoleRepository;
import com.platform.naxterbackend.post.model.Tag;
import com.platform.naxterbackend.post.repository.TagRepository;
import com.platform.naxterbackend.theme.model.Theme;
import com.platform.naxterbackend.theme.repository.ThemeRepository;
import com.platform.naxterbackend.user.model.User;
import com.platform.naxterbackend.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class InitDataRunner implements ApplicationRunner {

    private final static Logger logger = LoggerFactory.getLogger(InitDataRunner.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    SubscriptionRepository subscriptionRepository;
    @Autowired
    ThemeRepository themeRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    TagRepository tagRepository;
    @Autowired
    MerchandisingRepository merchandisingRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public void run(ApplicationArguments args) {
        try {


            /* INIT DATA MERCHANDISING */


            this.merchandisingRepository.deleteAll();

            Item item1 = new Item("item1", "description1", null);

            this.itemRepository.save(item1);

            List<Item> items = new ArrayList<>();
            items.add(item1);

            Merchandising merchandising1 = new Merchandising("merchandising1", "description1", items);
            Merchandising merchandising2 = new Merchandising("merchandising2", "description2", new ArrayList<>());
            Merchandising merchandising3 = new Merchandising("merchandising3", "description3", new ArrayList<>());

            this.merchandisingRepository.save(merchandising1);
            this.merchandisingRepository.save(merchandising2);
            this.merchandisingRepository.save(merchandising3);


            /* INIT DATA USERS */


            this.profileRepository.deleteAll();
            this.userRepository.deleteAll();

            Profile profile1 = new Profile("Descripción del perfil de usuario 1 para la introducción de las características más destacables de este.", new Date(), 1, 2);
            Profile profile2 = new Profile("Descripción del perfil de usuario 2 para la introducción de las características más destacables de este.", new Date(), 2, 3);
            Profile profile3 = new Profile("Descripción del perfil de usuario 3 para la introducción de las características más destacables de este.", new Date(), 3, 4);
            Profile profile4 = new Profile("Descripción del perfil de usuario 4 para la introducción de las características más destacables de este.", new Date(), 4, 5);
            Profile profile5 = new Profile("Descripción del perfil de usuario 5 para la introducción de las características más destacables de este.", new Date(), 5, 6);
            Profile profile6 = new Profile("Descripción del perfil de usuario 6 para la introducción de las características más destacables de este.", new Date(), 6, 7);
            Profile profile7 = new Profile("Descripción del perfil de usuario 7 para la introducción de las características más destacables de este.", new Date(), 7, 8);
            Profile profile8 = new Profile("Descripción del perfil de usuario 8 para la introducción de las características más destacables de este.", new Date(), 8, 9);
            Profile profile9 = new Profile("Descripción del perfil de usuario 9 para la introducción de las características más destacables de este.", new Date(), 9, 10);
            Profile profile10 = new Profile("", null, 0, 0);

            this.profileRepository.save(profile1);
            this.profileRepository.save(profile2);
            this.profileRepository.save(profile3);
            this.profileRepository.save(profile4);
            this.profileRepository.save(profile5);
            this.profileRepository.save(profile6);
            this.profileRepository.save(profile7);
            this.profileRepository.save(profile8);
            this.profileRepository.save(profile9);
            this.profileRepository.save(profile10);

            Role roleGeneric = new Role(RoleEnum.GENERIC.getType(), RoleEnum.GENERIC.getDescription());
            Role roleConsumer = new Role(RoleEnum.CONSUMER.getType(), RoleEnum.CONSUMER.getDescription());
            Role roleProducer = new Role(RoleEnum.PRODUCER.getType(), RoleEnum.PRODUCER.getDescription());
            Role roleModerator = new Role(RoleEnum.MODERATOR.getType(), RoleEnum.MODERATOR.getDescription());
            Role roleAdmin = new Role(RoleEnum.ADMIN.getType(), RoleEnum.ADMIN.getDescription());

            this.roleRepository.save(roleGeneric);
            this.roleRepository.save(roleConsumer);
            this.roleRepository.save(roleProducer);
            this.roleRepository.save(roleModerator);
            this.roleRepository.save(roleAdmin);

            List<Role> roles1 = new ArrayList<Role>(Arrays.asList(roleGeneric));
            List<Role> roles2 = new ArrayList<Role>(Arrays.asList(roleGeneric));
            List<Role> roles3 = new ArrayList<Role>(Arrays.asList(roleConsumer));
            List<Role> roles4 = new ArrayList<Role>(Arrays.asList(roleConsumer));
            List<Role> roles5 = new ArrayList<Role>(Arrays.asList(roleProducer));
            List<Role> roles6 = new ArrayList<Role>(Arrays.asList(roleProducer));
            List<Role> roles7 = new ArrayList<Role>(Arrays.asList(roleModerator));
            List<Role> roles8 = new ArrayList<Role>(Arrays.asList(roleModerator));
            List<Role> roles9 = new ArrayList<Role>(Arrays.asList(roleAdmin));
            List<Role> roles10 = new ArrayList<Role>(Arrays.asList(roleAdmin));

            User user1 = new User("user_1", "user_1@gmail.com", "User1 Surname1 Surname2", this.passwordEncoder.encode("12345"), Boolean.FALSE, roles1, profile1, null);
            User user2 = new User("user_2", "user_2@gmail.com", "User2 Surname1 Surname2", this.passwordEncoder.encode("12345"), Boolean.FALSE, roles2, profile2, null);
            User user3 = new User("user_3", "user_3@gmail.com", "User3 Surname1 Surname2", this.passwordEncoder.encode("12345"), Boolean.FALSE, roles3, profile3, null);
            User user4 = new User("user_4", "user_4@gmail.com", "User4 Surname1 Surname2", this.passwordEncoder.encode("12345"), Boolean.FALSE, roles4, profile4, null);
            User user5 = new User("user_5", "user_5@gmail.com", "User5 Surname1 Surname2", this.passwordEncoder.encode("12345"), Boolean.FALSE, roles5, profile5, null);
            User user6 = new User("user_6", "user_6@gmail.com", "User6 Surname1 Surname2", this.passwordEncoder.encode("12345"), Boolean.FALSE, roles6, profile6, null);
            User user7 = new User("user_7", "user_7@gmail.com", "User7 Surname1 Surname2", this.passwordEncoder.encode("12345"), Boolean.FALSE, roles7, profile7, merchandising1);
            User user8 = new User("user_8", "user_8@gmail.com", "User8 Surname1 Surname2", this.passwordEncoder.encode("12345"), Boolean.FALSE, roles8, profile8, merchandising2);
            User user9 = new User("user_9", "user_9@gmail.com", "User9 Surname1 Surname2", this.passwordEncoder.encode("12345"), Boolean.FALSE, roles9, profile9, null);
            User user10 = new User("carlos_otero", "carlos_otero@gmail.com", "Carlos Otero Franjo", this.passwordEncoder.encode("12345"), Boolean.FALSE, roles10, profile10, merchandising3);

            this.userRepository.save(user1);
            this.userRepository.save(user2);
            this.userRepository.save(user3);
            this.userRepository.save(user4);
            this.userRepository.save(user5);
            this.userRepository.save(user6);
            this.userRepository.save(user7);
            this.userRepository.save(user8);
            this.userRepository.save(user9);
            this.userRepository.save(user10);


            /* INIT DATA SUBSCRIPTIONS */


            this.subscriptionRepository.deleteAll();


            /* INIT DATA POSTS */


            this.tagRepository.deleteAll();
            this.postRepository.deleteAll();
            this.themeRepository.deleteAll();

            Post post1 = new Post("post1", "description", Boolean.FALSE, null, user1, null, new Date(), new ArrayList<>());
            Post post2 = new Post("post2", "description", Boolean.FALSE, null, user2, null, new Date(), new ArrayList<>());
            Post post3 = new Post("post3", "description", Boolean.FALSE, null, user3, null, new Date(), new ArrayList<>());

            Tag tag1 = new Tag("tag1", "description1");
            Tag tag2 = new Tag("tag2", "description2");
            Tag tag3 = new Tag("tag3", "description3");

            this.tagRepository.save(tag1);
            this.tagRepository.save(tag2);
            this.tagRepository.save(tag3);

            List<Tag> tags1 = new ArrayList<>();
            tags1.add(tag1);
            List<Tag> tags2 = new ArrayList<>();
            tags2.add(tag2);
            List<Tag> tags3 = new ArrayList<>();
            tags3.add(tag3);

            post1.setTags(tags1);
            post2.setTags(tags2);
            post3.setTags(tags3);

            Theme theme1 = new Theme("theme1", "description1", user1);
            Theme theme2 = new Theme("theme2", "description2", user2);
            Theme theme3 = new Theme("theme3", "description3", user3);

            post1.setTheme(theme1);
            post2.setTheme(theme2);
            post3.setTheme(theme3);

            this.postRepository.save(post1);
            this.postRepository.save(post2);
            this.postRepository.save(post3);

            this.themeRepository.save(theme1);
            this.themeRepository.save(theme2);
            this.themeRepository.save(theme3);

        } catch (Exception e) {
            logger.error("Error en los registros de las entidades: " + e.getMessage());
        }
    }
}
