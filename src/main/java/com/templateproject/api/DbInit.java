package com.templateproject.api;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.templateproject.api.entity.Article;
import com.templateproject.api.entity.Category;
import com.templateproject.api.entity.Paragraph;
import com.templateproject.api.entity.Role;
import com.templateproject.api.entity.User;
import com.templateproject.api.repository.ArticleRepository;
import com.templateproject.api.repository.CategoryRepository;
import com.templateproject.api.repository.ParagraphRepository;
import com.templateproject.api.repository.RoleRepository;
import com.templateproject.api.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DbInit {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ParagraphRepository paragraphRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

@PostConstruct
    private void postConstruct() {
        Integer i = 0;
        if (i == 1) {
            Role roleUser = new Role("ROLE_USER");
            Role roleAdmin = new Role("ROLE_ADMIN");
            roleUser = roleRepository.save(roleUser);
            roleAdmin = roleRepository.save(roleAdmin);
            //public User(String firstName, String lastName, String username, String password, String email, Set<Role> roles)
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(roleUser);
            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(roleUser);
            adminRoles.add(roleAdmin);
            User Florian = new User("Florian", "Helaine", "Florian", "test", "florian@florian.fr", adminRoles);
            Florian.setPassword(passwordEncoder.encode(Florian.getPassword()));
            User Selin = new User("Selin", "AGZIBUYUK", "Selin", "test", "selin@selin.fr", adminRoles);
            Selin.setPassword(passwordEncoder.encode(Selin.getPassword()));
            User Guillaume = new User("Guillaume", "Gros", "Guillaume", "test", "guillaume@guillaume.fr", adminRoles);
            Guillaume.setPassword(passwordEncoder.encode(Guillaume.getPassword()));
            User Alexandre = new User("Alexandre", "Boutemy", "Alexandre", "test", "alexandre@alexandre.fr", adminRoles);
            Alexandre.setPassword(passwordEncoder.encode(Alexandre.getPassword()));
            User Patrick = new User("Patrick", "Harle", "Patrick", "test", "patrick@patrick.fr", adminRoles);
            Patrick.setPassword(passwordEncoder.encode(Patrick.getPassword()));
            Florian = userRepository.save(Florian);
            Selin = userRepository.save(Selin);
            Guillaume = userRepository.save(Guillaume);
            Alexandre = userRepository.save(Alexandre);
            Patrick = userRepository.save(Patrick);
            Category fun = new Category("Fun", "fun");
            Category sport = new Category("Sport", "sport");
            Category carie = new Category("Carie", "carie");
            Category miam = new Category("Miam", "miam");
            Category eco = new Category("Ça coute bonbon", "ca-coute-bonbon");
            fun = categoryRepository.save(fun);
            sport =categoryRepository.save(sport);
            carie = categoryRepository.save(carie);
            miam = categoryRepository.save(miam);
            eco = categoryRepository.save(eco);
            Article article1 = new Article(true, "Le caramel qui colle aux dents : pour ou contre ?", "le-caramel-qui-colle-aux-dents-pour-ou-contre", "Un sondage a été réalisé auprès de membres de la Wild Code School pour savoir s'ils aimaient le caramel qui colle aux dents. Des résultats surprenants, ou pas...", "https://media.istockphoto.com/id/516358950/fr/photo/partie-de-sucre-blanc.jpg?s=612x612&w=0&k=20&c=PQdHZX3hIDHlQQHHoHJNAGxyQun5ORH_4kXJteRYyUU=", Selin, miam);
            Article article2 = new Article(false, "La Maison du Diabète et des maladies chroniques - Marcq-en-Baroeul", "la-maison-du-diabete-et-des-maladies-chroniques-marcq-en-baroeul", "La sant\u00E9 et le bien-\u00EAtre de vos collaborateurs sont primordiaux pour le bon fonctionnement de votre entreprise.", "https://www.maison-diabete.com/wordpress/wp-content/uploads/slide_prestas.jpg", Patrick, carie);
            Article article3 = new Article(false, "Le Bus Santé sillonne les routes de la Région Hauts-de-France", "le-bus-sante-sillonne-les-routes-de-la-region-hauts-de-france", "Sensibiliser le grand public, et plus particuli\u00E8rement les personnes en situation pr\u00E9caire et/ou ayant un acc\u00E8s aux soins plus difficile.", "https://www.maison-diabete.com/wordpress/wp-content/uploads/slide_bus.jpg", Patrick, carie);
            Article article4 = new Article(false, "La pr\u00E9vention en actions !", "la-prevention-en-actions", "Des entretiens individuels avec une conseill\u00E8re en pr\u00E9vention sant\u00E9 (de formation infirmi\u00E8re et di\u00E9t\u00E9ticienne) et des ateliers collectifs", "https://www.maison-diabete.com/wordpress/wp-content/uploads/l%C3%A9gumes-642x428.jpg", Patrick, carie);
            Article article5 = new Article(false, "Salade de harengs aux lentilles", "salade-de-harengs-aux-lentilles", "Un petit plat sympa et facile \u00E0 pr\u00E9parer pour 4 personnes ! Succulent !", "https://www.mangerbouger.fr/manger-mieux/la-fabrique-a-menus/_next/image?url=https%3A%2F%2Fapi-prod-fam.mangerbouger.fr%2Fstorage%2Frecettes_generiques%2Fplatcomplet.png&w=1920&q=75", Patrick, miam);
            Article article6 = new Article(false, "Une id\u00E9e de sport : le Badminton", "une-idee-de-sport-le-badminton", "Objectif : Gagner deux sets en marquant, pour chacun, 21 points avant son adversaire avec 2 points d'\u00E9carts au minimum !", "https://www.mangerbouger.fr/var/mb/storage/images/_aliases/reference/2/6/3/6/6362-1-eng-GB/activite_physique_badminton.jpg", Patrick, sport);
            Article article7 = new Article(false, "Bien manger sans se ruiner", "bien-manger-sans-se-ruiner", "Petites astuces bonnes pour tous, pour l\u2019environnement et pour le porte-monnaie.", "https://www.mangerbouger.fr/var/mb/storage/images/_aliases/reference/2/6/3/6/6362-1-eng-GB/activite_physique_badminton.jpg", Florian, miam);
            Article article8 = new Article(false, "Sucre est aussi le nom d'une ville !", "sucre-est-aussi-le-nom-d'une-ville", "Le sucre c\u00F4t\u00E9 g\u00E9ographie.", "https://www.mangerbouger.fr/var/mb/storage/images/_aliases/reference/2/6/3/6/6362-1-eng-GB/activite_physique_badminton.jpg", Patrick, fun);
            Article article9 = new Article(false, "Sucre et \u00E9conomie", "sucre-et-enonomie", "Le sucre : un ingr\u00E9dient qui nourrit l'\u00E9conomie mondiale", "https://www.francebleu.fr/s3/cruiser-production/2023/02/240f9099-2f4c-4ef3-a587-a4f5dc953734/1200x680_reencodedfatimage_sucre.jpg", Selin, eco);
            Article article10 = new Article(true, "Candy Crush Saga : Les d\u00E9fis les plus ardus qui r\u00E9sistent aux joueurs les plus t\u00E9m\u00E9raires", "candy-crush-saga-defis-plus-ardus-qui-resistent-joueurs-plus-temeraires", "Plongez dans l'univers impitoyable de Candy Crush Saga, o\u00F9 seuls les plus vaillants pourront triompher des niveaux les plus redoutables. Entre strat\u00E9gie et pers\u00E9v\u00E9rance, d\u00E9couvrez les d\u00E9fis qui mettent les nerfs des joueurs \u00E0 rude \u00E9preuve.", "http://json.helaine.eu/CandyCrush.jpg", Florian, fun);
            //Article article = new Article(true, "", "", "", "", Florian, miam);
            article1 = articleRepository.save(article1);
            article2 = articleRepository.save(article2);
            article3 = articleRepository.save(article3);
            article4 = articleRepository.save(article4);
            article5 = articleRepository.save(article5);
            article6 = articleRepository.save(article6);
            article7 = articleRepository.save(article7);
            article8 = articleRepository.save(article8);
            article9 = articleRepository.save(article9);
            article10 = articleRepository.save(article10);
            Paragraph art1paragraph1 = new Paragraph("Introduction", 'I', "Le caramel, ce d\u00E9lice sucr\u00E9 et collant, est un incontournable pour de nombreux amateurs de sucreries. Cependant, il suscite \u00E9galement un d\u00E9bat anim\u00E9 : faut-il l'appr\u00E9cier sans retenue ou le mettre de c\u00F4t\u00E9 pour \u00E9viter les d\u00E9sagr\u00E9ments qu'il peut causer ? \u00C0 travers un sondage r\u00E9alis\u00E9 aupr\u00E8s d'un groupe de personnes, nous avons recueilli diff\u00E9rentes opinions. Dans cet article, nous explorerons les arguments en faveur et contre le caramel collant pour vous aider \u00E0 vous forger votre propre opinion.", article1);
            Paragraph art1paragraph2 = new Paragraph("Les partisans du caramel collant", 'P', "Suite au sondage effectu\u00E9 aupr\u00E8s des membres de la Wild Code School, \u00E0 ce jour, six d'entre eux ont exprim\u00E9 leur amour pour le caramel collant. Huit ont, au contraire, fait part de leur aversion profonde pour cette sucrecie. Concernant les six personnes pour, voici les raisons qui peuvent expliquer ce choix :</p><ol><li>Plaisir gustatif : Selon ces fervents d\u00E9fenseurs, le caramel collant procure une exp\u00E9rience gustative unique. Sa texture douce et fondante associ\u00E9e \u00E0 sa saveur sucr\u00E9e procure une sensation de satisfaction intense. Tradition : Le caramel fait partie de la culture culinaire depuis des g\u00E9n\u00E9rations. Pour certains, le caramel collant est un symbole d'authenticit\u00E9 et de nostalgie, rappelant des souvenirs d'enfance et de moments conviviaux. Vari\u00E9t\u00E9 de desserts : Le caramel collant est un ingr\u00E9dient cl\u00E9 dans de nombreux desserts appr\u00E9ci\u00E9s dans le monde entier. Tarte au caramel, cr\u00E8me caramel, flan, bonbons au caramel... Ces gourmandises ne seraient pas les m\u00EAmes sans la texture collante et d\u00E9licieuse du caramel.", article1);
            Paragraph art1paragraph3 = new Paragraph("Les opposants au caramel collant", 'P', "Probl\u00E8mes dentaires : Le caramel collant peut se loger entre les dents et provoquer des caries. Il est souvent difficile \u00E0 \u00E9liminer compl\u00E8tement, m\u00EAme avec un brossage minutieux. Les opposants soulignent l'importance de prendre soin de sa sant\u00E9 bucco-dentaire en \u00E9vitant les aliments collants. Risque d'\u00E9touffement : Le caramel collant peut poser un risque d'\u00E9touffement, en particulier pour les jeunes enfants ou les personnes \u00E2g\u00E9es. Sa consistance visqueuse peut obstruer les voies respiratoires si une petite quantit\u00E9 est aval\u00E9e de travers. Prise de poids : Le caramel est riche en sucre et en calories. Une consommation excessive de caramel collant peut contribuer \u00E0 une prise de poids non d\u00E9sir\u00E9e et \u00E0 des probl\u00E8mes de sant\u00E9 associ\u00E9s.", article1);
            Paragraph art1paragraph4 = new Paragraph("Conclusion", 'C', "Le d\u00E9bat autour du caramel collant reste donc ouvert, avec des arguments solides \u00E9manant des deux c\u00F4t\u00E9s. Finalement, la d\u00E9cision de consommer du caramel collant repose sur un \u00E9quilibre entre le plaisir gustatif qu'il procure et les \u00E9ventuels inconv\u00E9nients pour la sant\u00E9. Il est important de se rappeler que la mod\u00E9ration est la cl\u00E9 dans la d\u00E9gustation de tout aliment sucr\u00E9. Alors, que vous soyez pour ou contre le caramel collant, l'essentiel est de savourer vos sucreries pr\u00E9f\u00E9r\u00E9es avec mod\u00E9ration et de prendre soin de votre sant\u00E9 bucco-dentaire.", article1);

            Paragraph art10paragraph1 = new Paragraph("Quand Candy Crush Saga devient un v\u00E9ritable champ de bataille pour les accros du puzzle sucr\u00E9.", 'I', "Dans l'univers des jeux mobiles, Candy Crush Saga r\u00E8gne en ma\u00EEtre incontest\u00E9. Des millions de joueurs succombent \u00E0 la tentation de ce jeu de puzzle sucr\u00E9, mais peu d'entre eux parviennent \u00E0 surmonter les niveaux les plus ardus. Aujourd'hui, nous vous plongeons dans l'univers impitoyable de Candy Crush Saga, o\u00F9 seuls les plus vaillants pourront esp\u00E9rer triompher des d\u00E9fis les plus redoutables.", article10);
            Paragraph art10paragraph2 = new Paragraph("Le niveau 130 : Un cauchemar de sucreries", 'P', "Le niveau 130 est un v\u00E9ritable cauchemar de sucreries pour les joueurs de Candy Crush Saga. Les bonbons ray\u00E9s sont enferm\u00E9s dans des g\u00E9latines qui ne demandent qu'\u00E0 \u00EAtre lib\u00E9r\u00E9es. Mais attention, les obstacles sont nombreux et les combinaisons se font rares. Les joueurs devront user de strat\u00E9gie et de r\u00E9flexion pour triompher de ce niveau qui donne des sueurs froides.", article10);
            Paragraph art10paragraph3 = new Paragraph("Le niveau 342 : Une v\u00E9ritable bataille glac\u00E9e", 'P', "Plongez dans une v\u00E9ritable bataille glac\u00E9e au niveau 342 de Candy Crush Saga. Les bonbons sont emprisonn\u00E9s dans des blocs de gel solide, n\u00E9cessitant des combinaisons pr\u00E9cises pour les lib\u00E9rer. Avec un nombre limit\u00E9 de mouvements, chaque choix compte. Seuls les joueurs les plus rus\u00E9s et patients pourront esp\u00E9rer venir \u00E0 bout de ce d\u00E9fi glacial.", article10);
            Paragraph art10paragraph4 = new Paragraph("Le niveau 461 : Une lutte contre les bonbons pi\u00E9g\u00E9s", 'P', "Le niveau 461 de Candy Crush Saga est un v\u00E9ritable pi\u00E8ge sucr\u00E9. Les bonbons pi\u00E9g\u00E9s s'entrem\u00EAlent dans un labyrinthe de friandises, et les joueurs doivent faire preuve d'une logique implacable pour les \u00E9liminer. Mais attention aux combinaisons rat\u00E9es qui pourraient conduire \u00E0 un \u00E9chec cuisant. Seuls les plus pers\u00E9v\u00E9rants pourront esp\u00E9rer venir \u00E0 bout de ce niveau complexe.", article10);
            Paragraph art10paragraph5 = new Paragraph("Le niveau 677 : Une course contre le poison sucr\u00E9", 'P', "Au niveau 677, les joueurs sont plong\u00E9s dans une course contre le poison sucr\u00E9. Les bonbons empoisonn\u00E9s se multiplient \u00E0 chaque mouvement, rendant le d\u00E9fi de plus en plus insurmontable. Seuls les joueurs les plus aguerris et rapides pourront esp\u00E9rer emp\u00EAcher la propagation de cette substance toxique et atteindre les objectifs fix\u00E9s. Un v\u00E9ritable d\u00E9fi d'adresse et de sang-froid.", article10);
            Paragraph art10paragraph6 = new Paragraph("Le niveau 963 : Une \u00E9nigme chocolat\u00E9e", 'P', "Le niveau 963 de Candy Crush Saga propose une \u00E9nigme chocolat\u00E9e qui teste les limites des joueurs. Le chocolat envahit les bonbons \u00E0 chaque tour, obligeant les joueurs \u00E0 trouver des combinaisons ing\u00E9nieuses pour s'en d\u00E9barrasser. Mais attention, la strat\u00E9gie est \u00E9galement de mise pour atteindre les cibles sp\u00E9cifiques du niveau. Seuls les plus rus\u00E9s et patients pourront esp\u00E9rer triompher de cette \u00E9nigme gourmande.", article10);
            Paragraph art10paragraph7 = new Paragraph("Conclusion", 'C', "Candy Crush Saga est bien plus qu'un simple jeu de puzzle sucr\u00E9. C'est un d\u00E9fi pour les joueurs en qu\u00EAte d'adr\u00E9naline et de d\u00E9passement de soi. Les niveaux mentionn\u00E9s ci-dessus ne sont que la pointe de l'iceberg des d\u00E9fis qui attendent les joueurs intr\u00E9pides. Alors, oserez-vous plonger dans cette bataille sucr\u00E9e ?", article10);

            paragraphRepository.save(art1paragraph1);
            paragraphRepository.save(art1paragraph2);
            paragraphRepository.save(art1paragraph3);
            paragraphRepository.save(art1paragraph4);
            paragraphRepository.save(art10paragraph1);
            paragraphRepository.save(art10paragraph2);
            paragraphRepository.save(art10paragraph3);
            paragraphRepository.save(art10paragraph4);
            paragraphRepository.save(art10paragraph5);
            paragraphRepository.save(art10paragraph6);
            paragraphRepository.save(art10paragraph7);
            //Paragraph artparagraph = new Paragraph("", '', "", article1);
        }
    }
}