package com.fengzw.minimall.minimalluser.config;

import com.fengzw.minimall.minimalluser.domain.User;
import com.fengzw.minimall.minimalluser.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repo) {
        return args -> {
            var admin = new User(1L, "admin", "admin", "admin");
            var tester = new User(2L, "test", "test", "tester");
            var customer = new User(3L, "customer", "123", "customer1");
            var customer2 = new User(4L, "customer2", "123", "Lorem ipsum dolor sit amet, adhuc nihil munere sed in. " +
                    "Mel agam exerci labitur an, ad nominati tincidunt duo. Ut pro constituam eloquentiam philosophia" +
                    ". An vel impetus moderatius, eum possim veritus ne. Vix erat blandit oportere te. Enim tation " +
                    "percipit vim ea.\n" +
                    "\n" +
                    "Ne usu nullam putent nemore, minim gubergren ea sit. Ex pro iracundia vituperatoribus, vix an " +
                    "vitae theophrastus, quo et quidam disputationi. Soleat nominavi id vim, prompta dolorum " +
                    "scribentur nam in, ea quodsi scribentur eam. Per ea laoreet delicata, has in intellegam " +
                    "reformidans. Soluta possit deseruisse eu usu, ea est meliore corpora consequat.\n" +
                    "\n" +
                    "Illum harum vidisse ius at, dicta option ne vim, velit reformidans an his. Congue nonumes " +
                    "percipit sea ut. Verterem salutatus dissentiet eum id, quo no tale soluta expetenda. Mel possit " +
                    "bonorum et. An possim vituperata sadipscing ius, et sit homero accusam. Ius purto malis postea " +
                    "ad, eos sumo dico justo ne, invidunt gubergren interpretaris eu eam.\n" +
                    "\n" +
                    "Illum voluptua vel at, an quo doctus voluptatum referrentur. Et has tation interesset. In vitae " +
                    "doming vivendo quo, eu virtute copiosae usu. Sea integre definiebas ne, erant invidunt pri ea, " +
                    "ad eos error nostro. Nec ei aperiam inimicus, eu sit consul alterum conceptam.\n" +
                    "\n" +
                    "Eam ex delectus probatus, ut vis cibo quidam. Modo error et his, has no omnium maiorum fastidii." +
                    " Suas mucius mollis pro ei, iusto tamquam labores duo eu, no nec eros omnes postea. Atqui " +
                    "ocurreret comprehensam mei an, pro in ludus salutandi. Vim nostro expetendis ad, quis possim eu " +
                    "vix, mutat oblique pro no.");
            repo.saveAll(List.of(admin, tester, customer, customer2));
        };
    }
}
