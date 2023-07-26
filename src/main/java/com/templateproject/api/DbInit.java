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
                        // public User(String firstName, String lastName, String username, String
                        // password, String email, Set<Role> roles)
                        Set<Role> userRoles = new HashSet<>();
                        userRoles.add(roleUser);
                        Set<Role> adminRoles = new HashSet<>();
                        adminRoles.add(roleUser);
                        adminRoles.add(roleAdmin);
                        User Florian = new User("Florian", "Helaine", "Florian", "test", "florian@florian.fr",
                                        adminRoles);
                        Florian.setPassword(passwordEncoder.encode(Florian.getPassword()));
                        User Selin = new User("Selin", "AGZIBUYUK", "Selin", "test", "selin@selin.fr", adminRoles);
                        Selin.setPassword(passwordEncoder.encode(Selin.getPassword()));
                        User Guillaume = new User("Guillaume", "Gros", "Guillaume", "test", "guillaume@guillaume.fr",
                                        adminRoles);
                        Guillaume.setPassword(passwordEncoder.encode(Guillaume.getPassword()));
                        User Alexandre = new User("Alexandre", "Boutemy", "Alexandre", "test", "alexandre@alexandre.fr",
                                        adminRoles);
                        Alexandre.setPassword(passwordEncoder.encode(Alexandre.getPassword()));
                        User Patrick = new User("Patrick", "Harle", "Patrick", "test", "patrick@patrick.fr",
                                        adminRoles);
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
                        sport = categoryRepository.save(sport);
                        carie = categoryRepository.save(carie);
                        miam = categoryRepository.save(miam);
                        eco = categoryRepository.save(eco);
                        Article article1 = new Article(true, "Le caramel qui colle aux dents : pour ou contre ?",
                                        "le-caramel-qui-colle-aux-dents-pour-ou-contre",
                                        "Un sondage a été réalisé auprès de membres de la Wild Code School pour savoir s'ils aimaient le caramel qui colle aux dents. Des résultats surprenants, ou pas...",
                                        "https://media.istockphoto.com/id/516358950/fr/photo/partie-de-sucre-blanc.jpg?s=612x612&w=0&k=20&c=PQdHZX3hIDHlQQHHoHJNAGxyQun5ORH_4kXJteRYyUU=",
                                        Selin, miam);
                        Article article2 = new Article(false,
                                        "La Maison du Diabète et des maladies chroniques - Marcq-en-Baroeul",
                                        "la-maison-du-diabete-et-des-maladies-chroniques-marcq-en-baroeul",
                                        "La sant\u00E9 et le bien-\u00EAtre de vos collaborateurs sont primordiaux pour le bon fonctionnement de votre entreprise.",
                                        "https://www.maison-diabete.com/wordpress/wp-content/uploads/slide_prestas.jpg",
                                        Patrick, carie);
                        Article article3 = new Article(false,
                                        "Le Bus Santé sillonne les routes de la Région Hauts-de-France",
                                        "le-bus-sante-sillonne-les-routes-de-la-region-hauts-de-france",
                                        "Sensibiliser le grand public, et plus particuli\u00E8rement les personnes en situation pr\u00E9caire et/ou ayant un acc\u00E8s aux soins plus difficile.",
                                        "https://www.maison-diabete.com/wordpress/wp-content/uploads/slide_bus.jpg",
                                        Patrick, carie);
                        Article article4 = new Article(false, "La pr\u00E9vention en actions !",
                                        "la-prevention-en-actions",
                                        "Des entretiens individuels avec une conseill\u00E8re en pr\u00E9vention sant\u00E9 (de formation infirmi\u00E8re et di\u00E9t\u00E9ticienne) et des ateliers collectifs",
                                        "https://www.maison-diabete.com/wordpress/wp-content/uploads/l%C3%A9gumes-642x428.jpg",
                                        Patrick,
                                        carie);
                        Article article5 = new Article(false, "Salade de harengs aux lentilles",
                                        "salade-de-harengs-aux-lentilles",
                                        "Un petit plat sympa et facile \u00E0 pr\u00E9parer pour 4 personnes ! Succulent !",
                                        "https://www.mangerbouger.fr/manger-mieux/la-fabrique-a-menus/_next/image?url=https%3A%2F%2Fapi-prod-fam.mangerbouger.fr%2Fstorage%2Frecettes_generiques%2Fplatcomplet.png&w=1920&q=75",
                                        Patrick, miam);
                        Article article6 = new Article(false, "Une id\u00E9e de sport : le Badminton",
                                        "une-idee-de-sport-le-badminton",
                                        "Objectif : Gagner deux sets en marquant, pour chacun, 21 points avant son adversaire avec 2 points d'\u00E9carts au minimum !",
                                        "https://www.mangerbouger.fr/var/mb/storage/images/_aliases/reference/2/6/3/6/6362-1-eng-GB/activite_physique_badminton.jpg",
                                        Patrick, sport);
                        Article article7 = new Article(false, "Bien manger sans se ruiner",
                                        "bien-manger-sans-se-ruiner",
                                        "Petites astuces bonnes pour tous, pour l\u2019environnement et pour le porte-monnaie.",
                                        "https://img.freepik.com/photos-gratuite/gros-plan-sac-reutilisable-epicerie-herbe_23-2148523381.jpg?w=826&t=st=1689761312~exp=1689761912~hmac=30140aa1f44fd4bdd546694cb23c6748ed2ca3ed2974b34afeae9d3bfd296fab",
                                        Florian, miam);
                        Article article8 = new Article(false, "Sucre est aussi le nom d'une ville !",
                                        "sucre-est-aussi-le-nom-d'une-ville",
                                        "Le sucre c\u00F4t\u00E9 g\u00E9ographie.",
                                        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Sucre%2C_Bolivia_-_%2824545082440%29.jpg/1280px-Sucre%2C_Bolivia_-_%2824545082440%29.jpg",
                                        Patrick, fun);
                        Article article9 = new Article(false, "Sucre et \u00E9conomie", "sucre-et-enonomie",
                                        "Le sucre : un ingr\u00E9dient qui nourrit l'\u00E9conomie mondiale",
                                        "https://www.francebleu.fr/s3/cruiser-production/2023/02/240f9099-2f4c-4ef3-a587-a4f5dc953734/1200x680_reencodedfatimage_sucre.jpg",
                                        Selin, eco);
                        Article article10 = new Article(false,
                                        "Candy Crush Saga : Les d\u00E9fis les plus ardus qui r\u00E9sistent aux joueurs les plus t\u00E9m\u00E9raires",
                                        "candy-crush-saga-defis-plus-ardus-qui-resistent-joueurs-plus-temeraires",
                                        "Plongez dans l'univers impitoyable de Candy Crush Saga, o\u00F9 seuls les plus vaillants pourront triompher des niveaux les plus redoutables. Entre strat\u00E9gie et pers\u00E9v\u00E9rance, d\u00E9couvrez les d\u00E9fis qui mettent les nerfs des joueurs \u00E0 rude \u00E9preuve.",
                                        "http://json.helaine.eu/CandyCrush.jpg", Florian, fun);

                        Article article11 = new Article(false,
                                        "La recette du caramel maison \\u00E0 la casserole",
                                        "recette-caramel-maison-a-la-casserole",
                                        "La recette du caramel maison \u00E0 la casserole",
                                        "https://media.istockphoto.com/id/516358950/fr/photo/partie-de-sucre-blanc.jpg?s=612x612&w=0&k=20&c=PQdHZX3hIDHlQQHHoHJNAGxyQun5ORH_4kXJteRYyUU=",
                                        Patrick, miam);

                        Article article12 = new Article(false,
                                        "Sucre rapide : en consommer pour faire du sport ?",
                                        "sucre-rapide-sport",
                                        "Sucre rapide : en consommer pour faire du sport ?",
                                        "https://img-3.journaldesfemmes.fr/4WlGbnWThrB2rSOinFQA0BDDilE=/1500x/smart/e66706cc913f467d89918a4c5ea499ee/ccmcms-jdf/33251697.jpg",
                                        Patrick, sport);

                        Article article13 = new Article(false,
                                        "Inflation sucri\u00E8re ces derniers mois : on en parle ...",
                                        "explosion-prix-sucre",
                                        "Pourquoi le prix du sucre a-t-il explos\u00E9 ?",
                                        "https://www.leandri-conseils.fr/wp-content/uploads/2019/09/k4_14314678.jpg",
                                        Patrick, eco);

                        Article article14 = new Article(false,
                                        "Sucre : vers une catastrophe \u00E9conomique et \u00E9cologique dans le Nord !",
                                        "economie-sucre-en-peril-nord",
                                        "Economie sucri\u00E8re en p\u00E9ril dans le Nord",
                                        "https://lvdneng.rosselcdn.net/sites/default/files/dpistyles_v2/vdn_864w/2023/03/18/node_1304563/56031520/public/2023/03/18/B9733772789Z.1_20230318101056_000%2BGDJME7GGE.1-0.jpg?itok=pE6uOPbp1679140371",
                                        Florian, miam);

                        Article article15 = new Article(false,
                                        "Boucle autour du Viso et du Pain de Sucre - 6 jours",
                                        "boucle-autour-du-viso-et-du-pain-sucre ",
                                        "Boucle autour du Viso et du Pain de Sucre - 6 jours",
                                        "https://www.altituderando.com/local/cache-vignettes/L1200xH819/randoon14397-c1ef6.jpg",
                                        Patrick, fun);

                        Article article16 = new Article(false,
                                        "La glyc\u00E9mie",
                                        "la-glycmie",
                                        "On vous dit tout sur la glyc\u00E9mie",
                                        "https://www.federationdesdiabetiques.org/public/styles/article/public/content/1/img/istock-86501881-large.jpg?itok=uGA2502l",
                                        Patrick, carie);

                        Article article17 = new Article(false,
                                        "L'Effet \"Sugar Rush\" : Mythe ou R\u00E9alit\u00E9 ?",
                                        "leffet-sugar-rush-mythe-ou-ralit",
                                        "L'Effet \"Sugar Rush\" : Mythe ou R\u00E9alit\u00E9 ?",
                                        "https://post.medicalnewstoday.com/wp-content/uploads/sites/3/2020/02/324896_1100-1100x628.jpg",
                                        Alexandre, fun);
                        Article article18 = new Article(false,
                                        "Les Dragibus Haribo : Un Arc-en-ciel de Saveurs G\u00E9lifi\u00E9es",
                                        "les-dragibus-haribo-un-arc-en-ciel-de-saveurs-glifies",
                                        "Les Dragibus Haribo : Un Arc-en-ciel de Saveurs G\u00E9lifi\u00E9es",
                                        "https://www.generation-souvenirs.com/31048-thickbox_default/dragibus-soft-haribo.jpg",
                                        Alexandre, fun);
                        Article article19 = new Article(false,
                                        "Une Douce Histoire: La Cotation du Sucre en Bourse",
                                        "une-douce-histoire-la-cotation-du-sucre-en-bourse",
                                        "Une Douce Histoire: La Cotation du Sucre en Bourse",
                                        "https://www.boursedirect.fr/media/articles/aof/forte-hausse-des-cours-du-sucre-au-premier-semestre/analyses-1688137800.jpg",
                                        Alexandre, eco);
                        Article article20 = new Article(false,
                                        "Le Pop-corn sous l'emprise de l'inflation : Les d\u00E9fis d'une d\u00E9licieuse collation",
                                        "le-pop-corn-sous-lemprise-de-linflation-les-dfis-dune-dlicieuse-collation",
                                        "Le Pop-corn sous l'emprise de l'inflation : Les d\u00E9fis d'une d\u00E9licieuse collation",
                                        "https://media.gettyimages.com/id/1150346553/fr/photo/gros-plan-de-service-de-popcorn-dans-un-stand-de-concession-au-cin%C3%A9ma.jpg?s=612x612&w=0&k=20&c=Er8vJiGfqamt1K43nq0jV4LhPIs66SvAL6yJEGaYGNA=",
                                        Alexandre, eco);
                        Article article21 = new Article(false,
                                        "Hypoglyc\u00E9mie du sportif: que faut-il savoir ?",
                                        "hypoglycmie-du-sportif-que-faut-il-savoir",
                                        "Hypoglyc\u00E9mie du sportif: que faut-il savoir ?",
                                        "https://e.sport.fr/wp-content/uploads/2022/07/Image1-1.jpg?ezimgfmt=ngcb1/notWebP",
                                        Alexandre, sport);
                        // Article article = new Article(true, "", "", "", "", Florian, miam);

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
                        article11 = articleRepository.save(article11);
                        article12 = articleRepository.save(article12);
                        article13 = articleRepository.save(article13);
                        article14 = articleRepository.save(article14);
                        article15 = articleRepository.save(article15);
                        article16 = articleRepository.save(article16);
                        article17 = articleRepository.save(article17);
                        article18 = articleRepository.save(article18);
                        article19 = articleRepository.save(article19);
                        article20 = articleRepository.save(article20);
                        article21 = articleRepository.save(article21);

                        Paragraph art1paragraph1 = new Paragraph("Introduction", 'I',
                                        "Le caramel, ce d\u00E9lice sucr\u00E9 et collant, est un incontournable pour de nombreux amateurs de sucreries. Cependant, il suscite \u00E9galement un d\u00E9bat anim\u00E9 : faut-il l'appr\u00E9cier sans retenue ou le mettre de c\u00F4t\u00E9 pour \u00E9viter les d\u00E9sagr\u00E9ments qu'il peut causer ? \u00C0 travers un sondage r\u00E9alis\u00E9 aupr\u00E8s d'un groupe de personnes, nous avons recueilli diff\u00E9rentes opinions. Dans cet article, nous explorerons les arguments en faveur et contre le caramel collant pour vous aider \u00E0 vous forger votre propre opinion.",
                                        article1);
                        Paragraph art1paragraph2 = new Paragraph("Les partisans du caramel collant", 'P',
                                        "Suite au sondage effectu\u00E9 aupr\u00E8s des membres de la Wild Code School, \u00E0 ce jour, six d'entre eux ont exprim\u00E9 leur amour pour le caramel collant. Huit ont, au contraire, fait part de leur aversion profonde pour cette sucrecie. Concernant les six personnes pour, voici les raisons qui peuvent expliquer ce choix :Plaisir gustatif : Selon ces fervents d\u00E9fenseurs, le caramel collant procure une exp\u00E9rience gustative unique. Sa texture douce et fondante associ\u00E9e \u00E0 sa saveur sucr\u00E9e procure une sensation de satisfaction intense. Tradition : Le caramel fait partie de la culture culinaire depuis des g\u00E9n\u00E9rations. Pour certains, le caramel collant est un symbole d'authenticit\u00E9 et de nostalgie, rappelant des souvenirs d'enfance et de moments conviviaux. Vari\u00E9t\u00E9 de desserts : Le caramel collant est un ingr\u00E9dient cl\u00E9 dans de nombreux desserts appr\u00E9ci\u00E9s dans le monde entier. Tarte au caramel, cr\u00E8me caramel, flan, bonbons au caramel... Ces gourmandises ne seraient pas les m\u00EAmes sans la texture collante et d\u00E9licieuse du caramel.",
                                        article1);
                        Paragraph art1paragraph3 = new Paragraph("Les opposants au caramel collant", 'P',
                                        "Probl\u00E8mes dentaires : Le caramel collant peut se loger entre les dents et provoquer des caries. Il est souvent difficile \u00E0 \u00E9liminer compl\u00E8tement, m\u00EAme avec un brossage minutieux. Les opposants soulignent l'importance de prendre soin de sa sant\u00E9 bucco-dentaire en \u00E9vitant les aliments collants. Risque d'\u00E9touffement : Le caramel collant peut poser un risque d'\u00E9touffement, en particulier pour les jeunes enfants ou les personnes \u00E2g\u00E9es. Sa consistance visqueuse peut obstruer les voies respiratoires si une petite quantit\u00E9 est aval\u00E9e de travers. Prise de poids : Le caramel est riche en sucre et en calories. Une consommation excessive de caramel collant peut contribuer \u00E0 une prise de poids non d\u00E9sir\u00E9e et \u00E0 des probl\u00E8mes de sant\u00E9 associ\u00E9s.",
                                        article1);
                        Paragraph art1paragraph4 = new Paragraph("Conclusion", 'C',
                                        "Le d\u00E9bat autour du caramel collant reste donc ouvert, avec des arguments solides \u00E9manant des deux c\u00F4t\u00E9s. Finalement, la d\u00E9cision de consommer du caramel collant repose sur un \u00E9quilibre entre le plaisir gustatif qu'il procure et les \u00E9ventuels inconv\u00E9nients pour la sant\u00E9. Il est important de se rappeler que la mod\u00E9ration est la cl\u00E9 dans la d\u00E9gustation de tout aliment sucr\u00E9. Alors, que vous soyez pour ou contre le caramel collant, l'essentiel est de savourer vos sucreries pr\u00E9f\u00E9r\u00E9es avec mod\u00E9ration et de prendre soin de votre sant\u00E9 bucco-dentaire.",
                                        article1);

                        Paragraph art10paragraph1 = new Paragraph(
                                        "Quand Candy Crush Saga devient un v\u00E9ritable champ de bataille pour les accros du puzzle sucr\u00E9.",
                                        'I',
                                        "Dans l'univers des jeux mobiles, Candy Crush Saga r\u00E8gne en ma\u00EEtre incontest\u00E9. Des millions de joueurs succombent \u00E0 la tentation de ce jeu de puzzle sucr\u00E9, mais peu d'entre eux parviennent \u00E0 surmonter les niveaux les plus ardus. Aujourd'hui, nous vous plongeons dans l'univers impitoyable de Candy Crush Saga, o\u00F9 seuls les plus vaillants pourront esp\u00E9rer triompher des d\u00E9fis les plus redoutables.",
                                        article10);
                        Paragraph art10paragraph2 = new Paragraph("Le niveau 130 : Un cauchemar de sucreries", 'P',
                                        "Le niveau 130 est un v\u00E9ritable cauchemar de sucreries pour les joueurs de Candy Crush Saga. Les bonbons ray\u00E9s sont enferm\u00E9s dans des g\u00E9latines qui ne demandent qu'\u00E0 \u00EAtre lib\u00E9r\u00E9es. Mais attention, les obstacles sont nombreux et les combinaisons se font rares. Les joueurs devront user de strat\u00E9gie et de r\u00E9flexion pour triompher de ce niveau qui donne des sueurs froides.",
                                        article10);
                        Paragraph art10paragraph3 = new Paragraph(
                                        "Le niveau 342 : Une v\u00E9ritable bataille glac\u00E9e", 'P',
                                        "Plongez dans une v\u00E9ritable bataille glac\u00E9e au niveau 342 de Candy Crush Saga. Les bonbons sont emprisonn\u00E9s dans des blocs de gel solide, n\u00E9cessitant des combinaisons pr\u00E9cises pour les lib\u00E9rer. Avec un nombre limit\u00E9 de mouvements, chaque choix compte. Seuls les joueurs les plus rus\u00E9s et patients pourront esp\u00E9rer venir \u00E0 bout de ce d\u00E9fi glacial.",
                                        article10);
                        Paragraph art10paragraph4 = new Paragraph(
                                        "Le niveau 461 : Une lutte contre les bonbons pi\u00E9g\u00E9s",
                                        'P',
                                        "Le niveau 461 de Candy Crush Saga est un v\u00E9ritable pi\u00E8ge sucr\u00E9. Les bonbons pi\u00E9g\u00E9s s'entrem\u00EAlent dans un labyrinthe de friandises, et les joueurs doivent faire preuve d'une logique implacable pour les \u00E9liminer. Mais attention aux combinaisons rat\u00E9es qui pourraient conduire \u00E0 un \u00E9chec cuisant. Seuls les plus pers\u00E9v\u00E9rants pourront esp\u00E9rer venir \u00E0 bout de ce niveau complexe.",
                                        article10);
                        Paragraph art10paragraph5 = new Paragraph(
                                        "Le niveau 677 : Une course contre le poison sucr\u00E9", 'P',
                                        "Au niveau 677, les joueurs sont plong\u00E9s dans une course contre le poison sucr\u00E9. Les bonbons empoisonn\u00E9s se multiplient \u00E0 chaque mouvement, rendant le d\u00E9fi de plus en plus insurmontable. Seuls les joueurs les plus aguerris et rapides pourront esp\u00E9rer emp\u00EAcher la propagation de cette substance toxique et atteindre les objectifs fix\u00E9s. Un v\u00E9ritable d\u00E9fi d'adresse et de sang-froid.",
                                        article10);
                        Paragraph art10paragraph6 = new Paragraph("Le niveau 963 : Une \u00E9nigme chocolat\u00E9e",
                                        'P',
                                        "Le niveau 963 de Candy Crush Saga propose une \u00E9nigme chocolat\u00E9e qui teste les limites des joueurs. Le chocolat envahit les bonbons \u00E0 chaque tour, obligeant les joueurs \u00E0 trouver des combinaisons ing\u00E9nieuses pour s'en d\u00E9barrasser. Mais attention, la strat\u00E9gie est \u00E9galement de mise pour atteindre les cibles sp\u00E9cifiques du niveau. Seuls les plus rus\u00E9s et patients pourront esp\u00E9rer triompher de cette \u00E9nigme gourmande.",
                                        article10);
                        Paragraph art10paragraph7 = new Paragraph("Conclusion", 'C',
                                        "Candy Crush Saga est bien plus qu'un simple jeu de puzzle sucr\u00E9. C'est un d\u00E9fi pour les joueurs en qu\u00EAte d'adr\u00E9naline et de d\u00E9passement de soi. Les niveaux mentionn\u00E9s ci-dessus ne sont que la pointe de l'iceberg des d\u00E9fis qui attendent les joueurs intr\u00E9pides. Alors, oserez-vous plonger dans cette bataille sucr\u00E9e ?",
                                        article10);

                        Paragraph art11paragraph1 = new Paragraph("Pour un caramel toujours r\u00E9ussi", 'I',
                                        "La recette classique pour faire son caramel \u00E0 la casserole \u00E0 la maison.",
                                        article11);
                        Paragraph art11paragraph2 = new Paragraph("Ingredients", 'P',
                                        "100 g de sucre de pr\u00E9f\u00E9rence en morceaux\r\n" + //
                                                        "2 cuiller\u00E9es \u00E0 soupe d'eau (30 ml)\r\n" + //
                                                        "Quelques gouttes de vinaigre blanc \u00E0 passer sur la casserole avant de commencer",
                                        article11);
                        Paragraph art11paragraph3 = new Paragraph("Pr\u00E9paration", 'P',
                                        "1-Passer un peu de vinaigre blanc sur le fond et les parois de la casserole\r\n"
                                                        + //
                                                        "2-Mettre sucre et eau dans une casserole correspondant \u00E0 la taille du feu et dissoudre le sucre dans l'eau d\u00E9licatement sans en mettre sur les bords\r\n"
                                                        + //
                                                        "3-Faire bouillir. Ensuite ne plus remuer \u00E0 la spatule, ni bouger la casserole.\r\n"
                                                        + //
                                                        "Quand la coloration appara\u00EEt, remuer l\u00E9g\u00E8rement la casserole pour r\u00E9partir la coloration\r\n"
                                                        + //
                                                        "4-Attention \u00E0 bien surveiller la coloration : trop claire \u00E7a ne fait que sucrer; trop fonc\u00E9e c'est \u00E2cre donc immangeable !",
                                        article11);
                        Paragraph art11paragraph4 = new Paragraph("Trucs & astuces", 'P',
                                        "Faire son caramel est facile mais il faut prendre des pr\u00E9cautions pour que tout se passe bien :\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "- Toujours utiliser du sucre blanc. A choisir, pr\u00E9f\u00E9rer le sucre en morceaux au sucre en poudre qui contiendrait moins d'impuret\u00E9s.\r\n"
                                                        + //
                                                        "Le mat\u00E9riel doit \u00EAtre tr\u00E8s propre. C'est pourquoi on peut passer un peu vinaigre blanc sur les parois tout ceci afin d'\u00E9viter toute impuret\u00E9 qui pourrait faire cristalliser le sucre.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "- Au pr\u00E9alable bien dissoudre le sucre avec l'eau sans en mettre sur les parois de la casserole.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "- Pendant la cuisson du sucre, il est tr\u00E8s important de ne pas y toucher : surtout ne pas m\u00E9langer \u00E0 la spatule, ni remuer la casserole avant le d\u00E9but de la coloration, ni ajouter d'eau froide: Ne rien faire sauf surveiller !\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "La cuisson va vite et il ne faut pas quitter son caramel des yeux ",
                                        article11);
                        Paragraph art11paragraph5 = new Paragraph("Nettoyage", 'P',
                                        "La poser dans l'\u00E9vier, attendre un d\u00E9but de refroidissement puis mettre de l'eau; \u00E7a fond tout seul. ",
                                        article11);
                        Paragraph art11paragraph6 = new Paragraph("Moulage", 'P',
                                        "Chemiser = r\u00E9partir le caramel dans le moule. Attention op\u00E9ration d\u00E9licate, faire tr\u00E8s attention car le caramel est br\u00FBlant.\r\n"
                                                        + //
                                                        "D\u00E8s l'apparition de la belle couleur blonde, verser le caramel dans le moule \u00E0 chemiser en l'inclinant pour napper les bords sans se br\u00FBler !!!\r\n"
                                                        + //
                                                        "Il faut travailler assez vite car le sucre dans la casserole se solidifie vite !",
                                        article11);
                        Paragraph art11paragraph7 = new Paragraph("Caramel liquide", 'P',
                                        "Le caramel liquide sert \u00E0 parfumer une pr\u00E9paration.\r\n" + //
                                                        "D\u00E8s l'apparition de la belle couleur blonde, hors du feu, \r\n"
                                                        + //
                                                        "ajouter avec beaucoup de pr\u00E9cautions 1/2 verre d'eau : \r\n"
                                                        + //
                                                        "ATTENTION ! \u00E9loigner ses yeux, ses mains car les projections sont br\u00FBlantes !!! \r\n"
                                                        + //
                                                        "Une partie se re- solidifie et il faut le remettre sur feu doux pour le faire fondre. \r\n"
                                                        + //
                                                        "Quand tout est bien fondu, verser le caramel dans un flacon de verre et fermer.",
                                        article11);
                        Paragraph art11paragraph8 = new Paragraph("Utilisation du micro-ondes", 'P',
                                        "Cela peut rendre service car si le moule le permet, \r\n" + //
                                                        "on fait le caramel directement dedans : \r\n" + //
                                                        "m\u00E9langer le sucre et l'eau directement dans un plat ad\u00E9quat mais \r\n"
                                                        + //
                                                        "pas en plastique cependant, \u00E7a chauffe ! \r\n" + //
                                                        "ensuite 4 \u00E0 5 mn environ pour 900 w: \r\n" + //
                                                        "ATTENTION, cela d\u00E9pend de la puissance des appareils donc y \r\n"
                                                        + //
                                                        "aller progressivement dans le temps en surveillant bien la coloration !",
                                        article11);
                        Paragraph art11paragraph9 = new Paragraph("Partagez votre exp\u00E9rience !", 'C',
                                        "Envoyez nous SVP vos commentaires et retours d'exp\u00E9rience... ",
                                        article11);
                        Paragraph art12paragraph1 = new Paragraph("Les r\u00E8gles de consommation de sucre rapide...",
                                        'I',
                                        "Il tient une place importante dans notre alimentation. Le sucre permet de rester en bonne sant\u00E9. \r\n"
                                                        + //
                                                        "Il est important de connaitre \u00E0 quel moment le consommer, comment et surtout en quelle quantit\u00E9. \r\n"
                                                        + //
                                                        "Et si vous \u00EAtes un sportif, aucune erreur n\u2019est permise en mati\u00E8re de consommation de sucre. \r\n"
                                                        + //
                                                        "De plus, tous les sucres ne se valent pas. Comment consommer du sucre rapide ? O\u00F9 le trouver ? \r\n"
                                                        + //
                                                        "Est-ce sans danger pour la sant\u00E9 ? \r\n" + //
                                                        "Quelques r\u00E9ponses \u00E0 toutes ces interrogations. ",
                                        article12);
                        Paragraph art12paragraph2 = new Paragraph("Les conteneurs de sucres rapides.",
                                        'P',
                                        "Les sucres rapides se stockeront instantan\u00E9ment dans le corps. \r\n" + //
                                                        "Sur une \u00E9chelle d\u2019index glyc\u00E9mique, les sucres rapides sont ceux qui poss\u00E8dent un IG sup\u00E9rieur \u00E0 70. \r\n"
                                                        + //
                                                        "En voici une liste non exhaustive :\r\n" + //
                                                        "\r\n" + //
                                                        "Tous les produits de boulangerie faits de farine blanche\r\n" + //
                                                        ", c\u00E9r\u00E9ales les plus emball\u00E9es\r\n" + //
                                                        ", miel\r\n" + //
                                                        ", lait\r\n" + //
                                                        ", le sucre de table\r\n" + //
                                                        ", le sirop de ma\u00EFs\r\n" + //
                                                        ", jus de fruits\r\n" + //
                                                        ", confiserie\r\n" + //
                                                        ", g\u00E2teau\r\n" + //
                                                        ", pain \u00E0 la farine blanche\r\n" + //
                                                        ", p\u00E2tes \u00E0 base de farine blanche\r\n" + //
                                                        ", bonbons\r\n" + //
                                                        ", yaourt\r\n" + //
                                                        ", confiture\r\n" + //
                                                        ", chocolat (blanc, noir, au lait)\r\n" + //
                                                        ", les boissons gazeuses\r\n" + //
                                                        ", biscuit\r\n" + //
                                                        ", glaces...\r\n" + //
                                                        "Ces aliments sont consid\u00E9r\u00E9s comme \u00E9tant \u00AB mauvais \u00BB pour la sant\u00E9. \r\n"
                                                        + //
                                                        "Toutefois, le sportif a plusieurs int\u00E9r\u00EAts \u00E0 les consommer mais pas n\u2019importe comment \r\n"
                                                        + //
                                                        "et encore moins \u00E0 n\u2019importe quel moment de la journ\u00E9e.",
                                        article12);
                        Paragraph art12paragraph3 = new Paragraph("A quel moment consommer ?",
                                        'P',
                                        "Veillez \u00E0 un apport suffisant et r\u00E9gulier en sucres rapides pendant l\u2019effort physique, puis \u00E0 l\u2019hydratation n\u00E9cessaire \u00E0 l\u2019organisme. \r\n"
                                                        + //
                                                        "Le sucre rapide est indispensable pour le sportif, moyen de rester au top de sa forme en boostant plus efficacement son organisme. \r\n"
                                                        + //
                                                        "La consommation de sucre lent est indispensable afin d\u2019\u00E9vier \"le coup de barre\", \r\n"
                                                        + //
                                                        "ces pertes de r\u00E9gimes et de vigilance trop soudaines li\u00E9es \u00E0 la baisse de glyc\u00E9mie\r\n"
                                                        + //
                                                        "(l'organisme puise alors dans les r\u00E9serves de sucres qui se situent dans le foie, puis si cela ne suffit plus, dans celles des muscles).\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Ces sucres rapides r\u00E9sident dans la consommation de boissons \u00E9nergisantes.  \r\n"
                                                        + //
                                                        "Certaines sont m\u00EAme formul\u00E9es pour r\u00E9pondre \u00E0 des besoins sp\u00E9cifiques. \r\n"
                                                        + //
                                                        "Sous forme de : gel, suppl\u00E9ment pour les sportifs, confiseries et autres, ces sucres rapides sont point\u00E9s du doigt. \r\n"
                                                        + //
                                                        "Ils augmenteront la production d\u2019insuline et la croissance de prot\u00E9ine dans les tissus musculaires.\r\n"
                                                        + //
                                                        "Ils occasionnent aussi une prise de poids rapide et importante\r\n"
                                                        + //
                                                        "Telle une \u00E9ponge, pressez-la jusqu\u2019\u00E0 ce qu\u2019elle soit totalement essor\u00E9e. \r\n"
                                                        + //
                                                        "C\u2019est comme cela que se pr\u00E9sentent les muscles apr\u00E8s un effort.\r\n"
                                                        + //
                                                        "Pour ceux qui veulent prendre du poids, se remettre en forme et booster l'organisme, athl\u00E8tes et culturistes peuvent les consommer. \r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Une bonne habitude \u00E0 adopter est de manger aussi un aliment riche en sucre rapide 30 minutes apr\u00E8s l\u2019effort. \r\n"
                                                        + //
                                                        "Ce d\u00E9lai permet aux muscles d\u2019absorber efficacement les glucides et de reprendre de la force imm\u00E9diatement.",
                                        article12);
                        Paragraph art12paragraph4 = new Paragraph("Bien choisir ses produits !",
                                        'C',
                                        "Ne vous ruez pas sur les sucreries, confiseries ou autres boissons \u00E9nergisantes. \r\n"
                                                        + //
                                                        "Mangez des barres de prot\u00E9ines que vous trouverez dans les magasins sp\u00E9cialis\u00E9s. \r\n"
                                                        + //
                                                        "Elles entrainent un apport en glucides et en prot\u00E9ines.",
                                        article12);
                        Paragraph art13paragraph1 = new Paragraph("Hausse du sucre act\u00E9e",
                                        'I',
                                        "Le prix du sucre a explos\u00E9 ces derni\u00E8res semaines. \r\n" + //
                                                        "Le kilo de sucre 1er prix est pass\u00E9, entre d\u00E9cembre et janvier, de 0.95 euros \u00E0 1.29 euros. \r\n"
                                                        + //
                                                        "Son prix a donc augment\u00E9 de 34 centimes en un mois. \r\n"
                                                        + //
                                                        "Sur un an, le kilo de sucre 1er prix a augment\u00E9 de 45%. \r\n"
                                                        + //
                                                        "En cause, la hausse du cours mondial, qui s'explique par plusieurs facteurs.",
                                        article13);
                        Paragraph art13paragraph2 = new Paragraph("Le cours du sucre est au plus haut !",
                                        'P',
                                        "Toutes les marques sont concern\u00E9es : les premiers prix, mais aussi les marques distributeurs et les marques nationales.\r\n"
                                                        + //
                                                        "En cause, la hausse des cours du sucre au niveau mondial : \"Le cours du sucre n'a jamais \u00E9t\u00E9 aussi haut\" , explique Emmanuel Cannes.\r\n"
                                                        + //
                                                        "Il a quasiment doubl\u00E9 entre avril 2020 et la fin 2022, passant de 8 \u00E0 9 cents de dollar la livre \u00E0 19 cents la livre.\r\n"
                                                        + //
                                                        "Cons\u00E9quence, tous les produits \u00E0 base de sucre augmentent eux aussi ! \r\n"
                                                        + //
                                                        "Bien qu'\u00E9lev\u00E9e, toutefois, l'inflation sur les sucres de marque a moins explos\u00E9 que celles des produits \u00E0 bas prix.",
                                        article13);
                        Paragraph art13paragraph3 = new Paragraph("L'effet de rattrapage",
                                        'P',
                                        "Cette envol\u00E9e s'explique par de nombreux facteurs. \r\n" + //
                                                        "Dont un effet principal et majeur de rattrapage apr\u00E8s quatre ans de prix tr\u00E8s bas, explique Christian Spiegeleer, le pr\u00E9sident du Syndicat national des fabricants de sucre. \r\n"
                                                        + //
                                                        "Les prix se sont en effet effondr\u00E9s avec la r\u00E9forme du march\u00E9 du sucre europ\u00E9en en 2017 : elle a mis en concurrence les pays europ\u00E9ens avec les plus grands producteurs mondiaux,\r\n"
                                                        + //
                                                        "comme le Br\u00E9sil , l'Inde ou la Tha\u00EFlande, et a entra\u00EEn\u00E9 l'abandon des quotas de production. \r\n"
                                                        + //
                                                        "Cela a pu donner l'illusion que ces prix \u00E9taient des prix de march\u00E9 standard.",
                                        article13);
                        Paragraph art13paragraph4 = new Paragraph("Entre climat et guerre des quotas",
                                        'P',
                                        "Le Br\u00E9sil, qui repr\u00E9sente 50% du march\u00E9 mondial gr\u00E2ce \u00E0 sa culture de canne \u00E0 sucre tr\u00E8s concurrentielle, a subi d'importantes inondations ces derniers mois, qui ont d\u00E9cal\u00E9 sa production.\r\n"
                                                        + //
                                                        "Mais ce n'est pas tout : le Br\u00E9sil produit \u00E9galement de l'\u00E9thanol, destin\u00E9 au biocarburants, \u00E0 partir de ses cannes \u00E0 sucre. Et en fonction du prix des carburants, le pays opte pour la production la plus rentable entre sucre et \u00E9thanol. Des choix qui jouent forc\u00E9ment sur le niveau de l'offre, et donc les prix.\r\n"
                                                        + //
                                                        "Dans le m\u00EAme temps, l'Inde a encore r\u00E9duit ses quotas d'exportation du sucre pour la campagne 2023, ce qui tend encore l'offre et favorise la hausse des cours.",
                                        article13);
                        Paragraph art13paragraph5 = new Paragraph(
                                        "Inciter les producteurs \u00E0 ne surtout pas se d\u00E9tourner de la betterave !",
                                        'P',
                                        "L'interdiction des n\u00E9onicotino\u00EFdes, les insecticides \"tueurs d'abeilles\", pour les producteurs de betteraves fran\u00E7ais, va faire baisser les rendements des cultivateurs, \r\n"
                                                        + //
                                                        "et donc augmenter les prix. Dans le m\u00EAme temps, le co\u00FBt des engrais a lui aussi \u00E9galement explos\u00E9.\r\n"
                                                        + //
                                                        "Il convient donc d'inciter les cultivateurs \u00E0 continuer \u00E0 planter de la betterave sucri\u00E8re, alors que le cours des c\u00E9r\u00E9ales est au plus haut: \r\n"
                                                        + //
                                                        "les industriels les r\u00E9mun\u00E8rent donc mieux afin d'\u00E9viter l'effet de ciseau, d'\u00E9roder les marges des exploitants agricoles d\u00E9j\u00E0 tent\u00E9s d'abandonner ce type de production. ",
                                        article13);
                        Paragraph art13paragraph6 = new Paragraph(
                                        "Inflation suraliment\u00E9e par la hausse de l'\u00E9nergie.",
                                        'P',
                                        "Comme pour d'autres secteurs, l'augmentation des prix de l'\u00E9nergie fait aussi flamber la facture. \r\n"
                                                        + //
                                                        "Elle est devenue le premier poste de d\u00E9pense, devant m\u00EAme l\u2019achat des betteraves.\r\n"
                                                        + //
                                                        "\"Les sucreries sont tr\u00E8s \u00E9nergivores, notamment en gaz\", pr\u00E9cise Christian Spiegeleer \"... dont le prix a \u00E9t\u00E9 multipli\u00E9 par trois ou quatre depuis la guerre en Ukraine\".",
                                        article13);
                        Paragraph art13paragraph7 = new Paragraph("Envol\u00E9e qui devrait donc se poursuivre en 2023",
                                        'C',
                                        "L'industrie sucri\u00E8re va devoir investir massivement pour d\u00E9carboner ses usines, explique Christian Spiegeleer. \r\n"
                                                        + //
                                                        "Il estime que les 21 sucreries du secteur vont devoir investir entre un et deux milliards d'euros pour devenir plus vertueuses sur le plan environnemental. \r\n"
                                                        + //
                                                        "Tout \u00E7a va peser tr\u00E8s lourdement sur le prix du sucre qui continuera de monter cette ann\u00E9e 2023 !",
                                        article13);
                        Paragraph art14paragraph1 = new Paragraph(
                                        "123 emplois en jeu dans le secteur sucrier sur le Nord ",
                                        'I',
                                        "La coop\u00E9rative sucri\u00E8re Tereos a annonc\u00E9 hier son intention de fermer sa sucrerie d\u2019Escaud\u0153uvres dans le d\u00E9partement du Nord. \r\n"
                                                        + //
                                                        "123 emplois sont en jeu. Cette sucrerie est une des neuf que la coop\u00E9rative agricole Tereos poss\u00E8de en France. \r\n"
                                                        + //
                                                        "La coop\u00E9rative va devoir la fermer faute de rentabilit\u00E9. \r\n"
                                                        + //
                                                        "En temps normal, elle tournait 110 jours par an. Mais avec la chute des volumes de betteraves produits en France, c\u2019est moins de 50 jours par an. \r\n"
                                                        + //
                                                        "Les co\u00FBts sont devenus impossibles \u00E0 amortir.",
                                        article14);
                        Paragraph art14paragraph2 = new Paragraph("Une histoire \u00E9crite depuis longtemps",
                                        'P',
                                        "Cela fait d\u00E9j\u00E0 plusieurs ann\u00E9es que la fili\u00E8re betterave alertait sur le risque de casse lourde de nos capacit\u00E9s de production. \r\n"
                                                        + //
                                                        "Personne ne peut faire semblant d\u2019\u00EAtre surpris, nous payons-l\u00E0 les cons\u00E9quences de d\u00E9cisions \u00E0 contre-sens.\r\n"
                                                        + //
                                                        "Un encha\u00EEnement de faits. En 2016, la France avait d\u00E9cid\u00E9 de fa\u00E7on isol\u00E9e en Europe d\u2019interdire le traitement des semences de betteraves aux n\u00E9onicotino\u00EFdes via la loi Pompili sur la biodiversit\u00E9. \r\n"
                                                        + //
                                                        "Le monde agricole avait alert\u00E9 : il expliquait qu\u2019on faisait les choses \u00E0 l\u2019envers en interdisant sans solution alternative contre les pucerons, qu\u2019on faisait les choses \u00E0 l\u2019envers, qu\u2019on mettait la fili\u00E8re en danger. \r\n"
                                                        + //
                                                        "On lui avait ri au nez.\r\n" + //
                                                        "Ce qui devait arriver arriva. En 2020, infestation de pucerons vecteurs de jaunisse. \r\n"
                                                        + //
                                                        "D\u00E9sastre : un tiers de la r\u00E9colte de betteraves perdue en France, un outil industriel qui avait tourn\u00E9 \u00E0 vide.\r\n"
                                                        + //
                                                        "Ce n\u2019\u00E9tait qu\u2019un d\u00E9but, parce que la betterave \u00E9tait devenue tr\u00E8s risqu\u00E9e... \r\n"
                                                        + //
                                                        "Dans l\u2019urgence, on avait permis aux planteurs d\u2019utiliser par d\u00E9rogation des semences trait\u00E9es aux n\u00E9onicotino\u00EFdes, mais nombre de betteraviers avaient d\u00E9j\u00E0 jet\u00E9 l\u2019\u00E9ponge. \r\n"
                                                        + //
                                                        "Et puis la s\u00E9cheresse est pass\u00E9e par l\u00E0 : en 2022, Tereos a enregistr\u00E9 une collecte de betteraves 10% inf\u00E9rieure aux pr\u00E9visions. \r\n"
                                                        + //
                                                        "10%, quand on a 9 sucreries, \u00E7a veut dire qu\u2019une doit fermer...",
                                        article14);
                        Paragraph art14paragraph3 = new Paragraph("La faute \u00E0 l'Europe ?",
                                        'P',
                                        "Et fin janvier, la Cour de justice europ\u00E9enne a donn\u00E9 le coup de gr\u00E2ce\r\n"
                                                        + //
                                                        "Elle a interdit \u00E0 la France de poursuivre ses d\u00E9rogations sur les semences enrob\u00E9es pour 2023, \u00E0 quelques semaines des semis. \r\n"
                                                        + //
                                                        "L\u2019incertitude r\u00E9glementaire est d\u00E9l\u00E9t\u00E8re. \r\n"
                                                        + //
                                                        "R\u00E9sultat : d\u00E9couragement g\u00E9n\u00E9ral. \r\n" + //
                                                        "Les surfaces plant\u00E9es en betteraves vont encore baisser de 7 \u00E0 10% voire 15%. \r\n"
                                                        + //
                                                        "Ce n\u2019est plus tenable pour l\u2019industrie. C\u2019est pour \u00E7a qu\u2019Escaud\u0153uvres ferme. Ce qu\u2019il faut bien comprendre, c\u2019est qu\u2019une sucrerie, c\u2019est strat\u00E9gique. \r\n"
                                                        + //
                                                        "Cela ne sert pas seulement \u00E0 l\u2019industrie agroalimentaire, mais aussi \u00E0 la pharmacie, \u00E0 la chimie, \u00E0 l'\u00E9nergie, \u00E0 l'\u00E9levage.",
                                        article14);
                        Paragraph art14paragraph4 = new Paragraph(
                                        "Coup dur pour notre industrie et notre \u00E9conomie",
                                        'C',
                                        "L\u2019Europe a besoin de 20 millions de tonnes de sucre par an. Elle n\u2019en produit que 16 millions de tonnes, et la France, un gros quart qu\u2019elle exporte chez ses voisins. \r\n"
                                                        + //
                                                        "Le reste est import\u00E9 d\u2019Indon\u00E9sie, de Tha\u00EFlande et surtout du Br\u00E9sil. Ce que la France ne produit plus sera donc import\u00E9 du bout du monde.\r\n"
                                                        + //
                                                        "Merci pour l\u2019environnement. Le sucre de canne import\u00E9 est produit avec des m\u00E9thodes dont l\u2019Europe ne veut plus, avec des pesticides interdits chez nous. \r\n"
                                                        + //
                                                        "Et ce sucre traverse la plan\u00E8te en cargo, on fait difficilement pire comme cons\u00E9quences pour une loi pr\u00E9tendument verte.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Barbara Pompili avait pourtant tir\u00E9 le signal d'alarme en septembre 2020 : \u00AB S\u2019il n\u2019y a pas de solution (alternative aux n\u00E9onicotino\u00EFdes) d\u2019ici 2 ans, \r\n"
                                                        + //
                                                        "il n\u2019y aura plus de betteraves et il n\u2019y aura plus de sucre fabriqu\u00E9 en France \u00BB. \r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "La destruction de notre industrie et de notre ind\u00E9pendance \u00E9tait \u00E9crite, assum\u00E9e, avec ses cons\u00E9quences sur la souverainet\u00E9, l\u2019emploi, \r\n"
                                                        + //
                                                        "les externalisations des d\u00E9g\u00E2ts sur l\u2019environnement.",
                                        article14);
                        Paragraph art15paragraph1 = new Paragraph(
                                        "Tr\u00E8s bel itin\u00E9raire de 6 jours dans le massif du Queyras ",
                                        'I',
                                        "Un tr\u00E8s bel itin\u00E9raire de 6 jours dans le massif du Queyras autour du Viso et du Pain de Sucre. \r\n"
                                                        + //
                                                        "Il ne s'agit ni du Tour du Viso ni du Tour du Pain de Sucre mais plut\u00F4t d'un mix entre les deux ! \r\n"
                                                        + //
                                                        "Au programme, des sommets, des vues magnifiques, des passages techniques, de nombreux lacs et du d\u00E9nivel\u00E9 !",
                                        article15);
                        Paragraph art15paragraph2 = new Paragraph(
                                        "Comment y acc\u00E9der ?",
                                        'P',
                                        "Passer par Molines en Queyras en direction du col Agnel et se garer au niveau du dernier lacet avant le col.",
                                        article15);
                        Paragraph art15paragraph3 = new Paragraph(
                                        "Pr\u00E9cisions sur la difficult\u00E9",
                                        'P',
                                        "Effectu\u00E9 tel que pr\u00E9sent\u00E9, l\u2019itin\u00E9raire peut \u00EAtre consid\u00E9r\u00E9 comme difficile, principalement parce qu\u2019il comporte des passages techniques, notamment un tr\u00E8s technique au niveau du Pas des Sagnettes effectu\u00E9 sans \u00E9quipement de via ferrata mais o\u00F9 l\u2019\u00E9quipement est recommand\u00E9.\r\n"
                                                        + //
                                                        "Le col du couloir du Porc est aussi tr\u00E8s a\u00E9rien et peut impressionner. \r\n"
                                                        + //
                                                        "Il y a aussi quelques portions de hors sentier, mais rien de m\u00E9chant. \r\n"
                                                        + //
                                                        "En dehors de \u00E7a, la difficult\u00E9 vient surtout du d\u00E9nivel\u00E9. Il est \u00E9galement possible d\u2019adapter l\u2019itin\u00E9raire en fonction de votre niveau ou m\u00EAme le raccourcir si vous le souhaitez.\r\n"
                                                        + //
                                                        "Certaines \u00E9tapes sont volontairement d\u00E9s\u00E9quilibr\u00E9es (les 2 premi\u00E8res notamment), car l\u2019itin\u00E9raire a \u00E9t\u00E9 pens\u00E9 pour bivouaquer \u00E0 des endroits sp\u00E9cifiques, il peut aussi \u00EAtre r\u00E9\u00E9quilibr\u00E9 pour \u00E9viter d\u2019avoir des \u00E9tapes trop longues.\r\n"
                                                        + //
                                                        "\u00C0 noter que nous avons effectu\u00E9 ce tour d\u00E9but octobre et que nous avons termin\u00E9 une des \u00E9tapes dans la nuit (la descente du Sentiero Ezio Nicoli apr\u00E8s les lacs de Forcioline) car nous nous sommes fait surprendre par la \"via ferrata\" du Pas des Sagnettes. \r\n"
                                                        + //
                                                        "En \u00E9t\u00E9 lorsque les journ\u00E9es sont plus longues \u00E7a doit passer mais attention donc \u00E0 la longueur de certaines \u00E9tapes.",
                                        article15);
                        Paragraph art15paragraph4 = new Paragraph(
                                        "JOUR 1 : Col Agnel - Sommet du Pain de Sucre",
                                        'P',
                                        "\r\n" + //
                                                        "Distance : 1,6 km\r\n" + //
                                                        "D\u00E9nivel\u00E9 positif : 450 m\r\n" + //
                                                        "Bivouac au sommet du Pain de Sucre\r\n" + //
                                                        "Notre p\u00E9riple d\u00E9bute juste sous le col Agnel (2 744m). Nous partons assez tard (18h30 le temps de se pr\u00E9parer) et le soleil commence d\u00E9j\u00E0 \u00E0 se coucher. Nous nous mettons en marche pour le sommet du Pain de Sucre (3 208m). Le sentier est cairn\u00E9 et assez \u00E9vident au d\u00E9but. Sur la 2e partie les pierres sont parfois plus instables et le chemin moins \u00E9vident mais gr\u00E2ce aux cairns et \u00E0 quelques marques on arrive \u00E0 se d\u00E9brouiller.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "\u00C0 noter que nous avons termin\u00E9 le dernier tiers de l\u2019ascension dans la nuit \u00E0 la frontale donc c\u2019\u00E9tait forc\u00E9ment moins ais\u00E9 qu\u2019en plein jour.\r\n"
                                                        + //
                                                        "Nous avons atteint un premier bivouac que nous avons pens\u00E9 \u00EAtre celui du sommet mais en r\u00E9alit\u00E9 le bivouac principal du sommet, le plus \"confort\" (car il y a plus de place et il est beaucoup mieux abrit\u00E9) est un peu plus loin, au bout d\u2019une cr\u00EAte un peu a\u00E9rienne (que nous n\u2019aurions pas aim\u00E9 franchir de nuit).\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Si comme nous, vous souhaitez dormir au sommet du Pain de Sucre, choisissez une nuit o\u00F9 la m\u00E9t\u00E9o est certaine, o\u00F9 la visibilit\u00E9 est bonne et o\u00F9 le vent n\u2019est pas trop fort. Ne pas oublier que le sommet est \u00E0 3200m et que malgr\u00E9 le bivouac de fortune il est tr\u00E8s expos\u00E9 au vent. On ne peut bien s\u00FBr pas planter de tente en haut, donc attention aux temp\u00E9ratures !",
                                        article15);
                        Paragraph art15paragraph5 = new Paragraph(
                                        "JOUR 2 : Sommet du Pain de Sucre - Pic For\u00E9ant par le Col Vieux",
                                        'P',
                                        "\r\n" + //
                                                        "Distance : 6 km\r\n" + //
                                                        "D\u00E9nivel\u00E9 positif : 450 m\r\n" + //
                                                        "D\u00E9nivel\u00E9 n\u00E9gatif : 600 m\r\n" + //
                                                        "Bivouac juste de dessous du Pic For\u00E9ant\r\n" + //
                                                        "Le matin, nous repartons au d\u00E9but par le \"chemin\" par lequel nous sommes arriv\u00E9s puis nous en suivons ensuite un autre qui part plus \u00E0 droite et qui est mat\u00E9rialis\u00E9 par des marques rouges, en direction du col Vieux (2 806m). Une fois au col nous rejoignons le GR et nous descendons jusqu\u2019au lac For\u00E9ant.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Une fois le lac pass\u00E9 nous poursuivons encore quelques centaines de m\u00E8tres sur le GR jusqu\u2019\u00E0 rencontrer sur la gauche le lit d\u2019un torrent ass\u00E9ch\u00E9 (indiqu\u00E9 sur la carte IGN). \u00C0 noter que ce \"chemin\" n\u2019est pas mat\u00E9rialis\u00E9 sur l\u2019IGN mais il l\u2019est sur l\u2019open topo map. Malgr\u00E9 \u00E7a, le fameux \"chemin\" n\u2019existe pas vraiment, il vaut mieux un GPS pour s\u2019orienter et prendre au moins raide d\u2019abord en suivant le lit de la rivi\u00E8re ass\u00E9ch\u00E9e puis dans les pentes herbeuses. De cette fa\u00E7on on atteint d\u2019abord le premier des Lacs de l\u2019Eychassier sur sa rive droite puis on poursuit dans les pentes herbeuses jusqu\u2019\u00E0 retrouver un chemin peu marqu\u00E9 qui nous m\u00E8nera jusqu\u2019au plus grand des Lacs de l\u2019Eychassier.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "De l\u00E0 c\u2019est un peu plus \u00E9vident, nous suivons le chemin \u00E0 gauche qui passe devant le lac en direction du col de L\u2019Eychassier (2 917 m). Puis en continuant \u00E0 monter sur ce m\u00EAme chemin, nous atteignons la cr\u00EAte. On suit l\u2019ar\u00EAte sur le chemin marqu\u00E9, d\u2019abord large puis un peu plus a\u00E9rienne et min\u00E9rale, et enfin devenant large et herbeuse \u00E0 nouveau. Avant d\u2019arriver au Pic For\u00E9ant, nous avons trouv\u00E9 un espace herbeux plat sur la cr\u00EAte o\u00F9 nous avons pos\u00E9 notre tente, juste en face du Viso et du Pain de Sucre.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Le Pic For\u00E9ant (3081 m) s\u2019atteint ensuite facilement. De l\u00E0, la vue \u00E0 360\u00B0 avec le Viso et le Pain de Sucre en ligne de mire est vraiment magnifique !",
                                        article15);
                        Paragraph art15paragraph6 = new Paragraph(
                                        "JOUR 3 : Pic For\u00E9ant - Lac Porcieroles",
                                        'P',
                                        "\r\n" + //
                                                        "Distance : 20 km\r\n" + //
                                                        "D\u00E9nivel\u00E9 positif : 950 m\r\n" + //
                                                        "D\u00E9nivel\u00E9 n\u00E9gatif : 1350 m\r\n" + //
                                                        "Bivouac au bord du lac Porcieroles\r\n" + //
                                                        "Une grosse \u00E9tape en distance, mais pas si importante que \u00E7a en d\u00E9nivel\u00E9 positif, nous attend pour le 3e jour.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Apr\u00E8s avoir lev\u00E9 le camp, nous repassons pr\u00E8s du Pic For\u00E9ant pour entamer la descente, qui sera d\u2019ailleurs la th\u00E9matique ma\u00EEtresse de la premi\u00E8re partie de la journ\u00E9e.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Au d\u00E9but il faudra suivre la ligne de cr\u00EAte qui descend en direction des lacs de l\u2019Eychassier. Nous passons \u00E0 c\u00F4t\u00E9 du plus petit lac o\u00F9 nous finissons par r\u00E9cup\u00E9rer le chemin par lequel nous \u00E9tions arriv\u00E9es la veille. Nous continuons sur ce \"chemin\" qui n\u2019en est pas vraiment un jusqu\u2019\u00E0 r\u00E9cup\u00E9rer le sentier du GR58. Arriv\u00E9 sur le sentier du GR58, nous prenons \u00E0 gauche, au nord donc et marchons jusqu\u2019au lac Egorg\u00E9ou et y faisons une pause.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "\u00C0 noter d\u2019ailleurs qu\u2019une grande partie des rives de ce lac est interdite aux randonneurs pour pr\u00E9server la biodiversit\u00E9 du site.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Nous entamons ensuite la longue et \u00E9vidente descente vers le lieu-dit de l\u2019Echalp en suivant le GR58. Le sentier est plut\u00F4t agr\u00E9able et dans les sous-bois. Il longe pendant un moment le Torrent de Bouchouse sur sa gauche.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Nous suivons donc le GR58 jusqu\u2019au parking peu avant le lieu-dit de l\u2019Echalp. De l\u00E0, nous faisons quasiment demi-tour, en prenant au sud un chemin gravillonn\u00E9 et plat qui longe le Guil. Nous d\u00E9passons la Roche Ecroul\u00E9e puis nous nous retrouvons sur un sentier qui monte \u00E0 travers les bois et qui passe une premi\u00E8re fois la rivi\u00E8re pour atteindre le Petit Belv\u00E9d\u00E8re du Viso.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Apr\u00E8s avoir pass\u00E9 un second pont, nous retrouvons un chemin carrossable que nous suivrons quasiment compl\u00E8tement jusqu\u2019au Grand Belv\u00E9d\u00E8re du Viso (en fait, on peut choisir d\u2019atteindre le Belv\u00E9d\u00E8re en continuant \u00E0 suivre la route ou en coupant sur la droite par un sentier balis\u00E9, ce que nous avons fait).\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "\u00C0 partir de l\u00E0, nous laissons le sentier qui part vers le Nord dans le creux de la vall\u00E9e pour entamer la rude mont\u00E9e vers le refuge du Viso en suivant le GRP Tour du Pain de Sucre.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Au prix d\u2019environ 350 m\u00E8tres de d\u00E9nivel\u00E9, nous atteignons le Refuge du Viso (2 430m) puis une fois le refuge pass\u00E9, nous quittons le sentier principal qui se dirige vers le col de Valante pour aller un peu plus \u00E0 l\u2019est sur un plus petit sentier peu marqu\u00E9 mais balis\u00E9 par des traces jaunes en direction du Col du Couloir du Porc. La mont\u00E9e, douce au d\u00E9but devient un peu plus raide. Le sentier est toujours peu visible mais en suivant les marques jaunes c\u2019est assez \u00E9vident et nous atteignons assez vite le lac de Porcieroles o\u00F9 nous passerons la nuit.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "\u00C0 l\u2019origine nous avions pr\u00E9vu de passer le Col du Couloir du Porc le m\u00EAme jour mais l\u2019horaire tardif et la fatigue nous ont d\u00E9cid\u00E9s \u00E0 r\u00E9server cette entreprise au lendemain.",
                                        article15);
                        Paragraph art15paragraph7 = new Paragraph(
                                        "JOUR 4 : Lac Porcieroles - Gias d\u2019Ajaut",
                                        'P',
                                        "\r\n" + //
                                                        "Distance : 15 km\r\n" + //
                                                        "D\u00E9nivel\u00E9 positif : 1100 m\r\n" + //
                                                        "D\u00E9nivel\u00E9 n\u00E9gatif : 1700 m\r\n" + //
                                                        "Bivouac au bord du Torrent Vallanta peu avant le Gias d\u2019Ajaut\r\n"
                                                        + //
                                                        "Nous ne le savions pas en levant le camp mais le jour 4 a certainement \u00E9t\u00E9 le jour le plus \u00E9prouvant de notre p\u00E9riple !\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Nous partons t\u00F4t le matin en direction de l\u2019Italie par ce fameux col du Couloir du Porc. Du lac, \u00E7a para\u00EEt peu engageant, raide et en plein dans un pierrier. Dans la r\u00E9alit\u00E9 c\u2019est effectivement raide et assez expos\u00E9 mais moins pire que ce que nous pensions (attention tout de m\u00EAme si vous \u00EAtes sujet au vertige, il ne vaut mieux pas se louper \u00E0 certains endroits). C\u2019est toujours bien balis\u00E9 avec les fameuses marques jaunes.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Nous atteignons assez rapidement le col et ensuite c\u2019est la descente vers le refuge Giacoletti. La descente pour le coup nous aura donn\u00E9 plus de fil \u00E0 retordre. Le panneau en haut indique 20 minutes pour le refuge Giacoletti... Et bien nous mettrons \u00E0 peu pr\u00E8s 1 heure ! C\u2019est en fait une descente tr\u00E8s expos\u00E9e o\u00F9 il faut sans cesse s\u2019aider des chaines et faire tr\u00E8s attention. Avec les sacs tr\u00E8s lourds que nous avons, l\u2019erreur n\u2019est pas permise ! D\u2019ailleurs, nous croisons des randonneurs encord\u00E9s dans le sens inverse.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Nous passons sans encombre le refuge Giacoletti et prenons au sud-est en direction du refuge Quintino Sella. Nous apercevons rapidement les lacs : Lago Superiore, Lago Fiorenza puis le Lago Losetto que nous contournons par l\u2019est. Le dernier lac que nous passons est le Lago Chiaretto que nous avons contourn\u00E9 par l\u2019est mais que nous vous recommandons plut\u00F4t de contourner par l\u2019ouest pour rester plus ou moins \u00E0 niveau et vous \u00E9viter une remont\u00E9e assez p\u00E9nible (sauf si vous souhaitez faire une pause au bord du lac).\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Apr\u00E8s une partie de lacets assez raides, on rejoint un immense pierrier bien balis\u00E9. L\u2019ambiance, apr\u00E8s les lacs, change vraiment du tout au tout ! C\u2019est un univers tr\u00E8s min\u00E9ral, presque lunaire. On quitte le pierrier puis on atteint facilement le refuge Quintino Sella apr\u00E8s une courte descente.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Et apr\u00E8s, c\u2019est l\u00E0 que \u00E7a se corse !\r\n" + //
                                                        "\r\n" + //
                                                        "Notre objectif \u00E9tait de passer dans la vall\u00E9e voisine par le Passo del Sagnette (2 990m). Pour cela nous partons au sud apr\u00E8s le refuge, puis \u00E0 l\u2019intersection avec le chemin qui continue au sud dans la vall\u00E9e, nous d\u00E9vions vers l\u2019ouest et nous nous \u00E9levons en direction de ce fameux pas. Nous croisons dans le sens inverse des italiens avec casques et baudriers et nous commen\u00E7ons \u00E0 nous interroger.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Plus loin, une pancarte sur le rocher indique en italien la \"Via Ferrata du Pas des Sagnettes\". Grave erreur, nous n\u2019avions pas suffisamment \u00E9tudi\u00E9 la carte et les topos et avions \"loup\u00E9\" ce petit d\u00E9tail. Par chance, je capte et je fais quelques recherche sur internet pour savoir \u00E0 quoi ressemble cette via ferrata. Je lis plusieurs topo fran\u00E7ais qui expliquent que \"\u00E7a passe\" sans \u00E9quipement avec le pied un peu montagnard. Nous d\u00E9cidons de tenter le coup.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Le d\u00E9but est tr\u00E8s facile bien qu\u2019expos\u00E9, il n\u2019y a pas vraiment d\u2019escalade. Nous croisons un groupe d\u2019italiens qui nous disent que \u00E7a se complique ensuite. Nous continuons. La seconde partie est effectivement plus grimpante et bien expos\u00E9e mais il y a de nombreuses chaines pour s\u2019aider. Nous croisons un couple de fran\u00E7ais (\u00E9galement sans \u00E9quipement) qui nous rassurent en nous disant que nous sommes presque arriv\u00E9es en haut. De leur c\u00F4t\u00E9, ils venaient de faire le Viso sans \u00E9quipement... Un dernier effort et c\u2019est le sommet ! Finalement ce n\u2019\u00E9tait pas si dur que \u00E7a !\r\n"
                                                        + //
                                                        "La difficult\u00E9 principale vient en fait du poids des sacs, mais sinon avec tout l\u2019\u00E9quipement en place et un pied s\u00FBr, c\u2019est faisable en faisant attention !\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "\u00C0 partir de l\u00E0, nous pensions vraiment qu\u2019il nous restait plus qu\u2019une longue descente tranquille... Et bien absolument pas !\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Nous descendons prudemment dans le pierrier par le sentiero Ezio Nicoli (il n\u2019y a pas vraiment de sentier en r\u00E9alit\u00E9, mais quelques marques par ci par l\u00E0), c\u2019est assez paumatoire, il vaut finalement mieux trouver un cap et le garder. Au bout d\u2019un moment nous atteignons le Lago Superiore delle Forciolline et le Bivacco Boarelli. Nous continuons sur le sentier, \u00E0 pr\u00E9sent plus \u00E9vident vers l\u2019est et passons quelques passages un peu plus difficiles o\u00F9 il faut s\u2019aider de c\u00E2bles et de chaines.\r\n"
                                                        + //
                                                        "Il est d\u00E9j\u00E0 bien tard et d\u00E9cidons de manger avant d\u2019attaquer la descente. Nous savons d\u00E9j\u00E0 que nous allions devoir la faire en partie de nuit vu l\u2019horaire mais nous tenons \u00E0 aller tout en bas pour nous avancer un maximum en pr\u00E9vision de la journ\u00E9e du lendemain qui s\u2019annonce elle aussi \u00E9prouvante.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Nous attaquons donc la descente sur ce fameux sentier Ezio Nicoli. Une descente tout bonnement inf\u00E2me, du moins de nuit (la journ\u00E9e, la vue doit \u00EAtre tr\u00E8s belle j\u2019imagine...). C\u2019est un m\u00E9lange de pierrier, d\u2019\u00E9boulis raides et parfois expos\u00E9s o\u00F9 il est difficile (\u00E0 fortiori la nuit et avec une frontale qui ne fonctionne plus) de trouver son chemin. Le \"chemin\" est marqu\u00E9 par des traces blanches et serpente, tant\u00F4t \u00E0 gauche, tant\u00F4t \u00E0 droite de la rivi\u00E8re. \u00C0 plusieurs reprises il faut \u00E9galement s\u2019aider de cha\u00EEnes pour descendre.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Au bout d\u2019un certain temps (qui a paru interminable tant nous \u00E9tions lentes sur ce terrain), nous retrouvons un chemin plus marqu\u00E9, beaucoup moins raide et plus agr\u00E9able dans l\u2019herbe, puis dans la for\u00EAt et enfin nous atteignons la jonction entre le sentier Ezio Nicoli et le chemin principal que nous prendrons le lendemain.\r\n"
                                                        + //
                                                        "Nous n\u2019allons pas plus loin (il est 21h30 !) et plantons la tente pr\u00E8s du torrent Vallanta.",
                                        article15);
                        Paragraph art15paragraph8 = new Paragraph(
                                        "JOUR 5 : Gias d\u2019Ajaut - Lac Blanchet sup\u00E9rieur par le Colle Losetta et le Col de St V\u00E9ran",
                                        'P',
                                        "\r\n" + //
                                                        "Distance : 18 km\r\n" + //
                                                        "D\u00E9nivel\u00E9 positif : 1700 m\r\n" + //
                                                        "D\u00E9nivel\u00E9 n\u00E9gatif : 900 m\r\n" + //
                                                        "Bivouac au bord du Lac Blanchet sup\u00E9rieur\r\n" + //
                                                        "C\u2019est encore une grosse journ\u00E9e qui nous attend et avec la fatigue accumul\u00E9e, en particulier celle de la veille, elle s\u2019annonce \u00E9prouvante !\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Le d\u00E9part est bucolique et \u00E9vident, nous atteignons rapidement le hameau de Gias d\u2019Ajaut, et nous traversons le pont en rive droite puis nous montons doucement tout en longeant le torrente Vallanta pendant un bon moment avec une vue de plus en plus belle sur le Viso sur un versant que nous n\u2019avions pas encore eu l\u2019occasion de voir jusqu\u2019\u00E0 pr\u00E9sent. Nous finissons par atteindre un croisement avec un sentier qui part plus \u00E0 l\u2019est en direction du refuge Vallanta et du lac \u00E9ponyme. Nous le laissons et continuons de nous \u00E9lever direction nord-ouest vers le Colle Losetta. Apr\u00E8s de nombreux lacets nous atteignons une ancienne caserne puis peu apr\u00E8s le Colle Losetta (2 872m).\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "S\u2019ensuit apr\u00E8s une longue mais facile descente dans le creux de la vall\u00E9e. Nous rencontrons au col et dans le d\u00E9but de la descente un peu de neige fra\u00EEchement tomb\u00E9e la veille ce qui rend le chemin un peu glissant mais la suite est facile et plut\u00F4t reposante.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "\u00C0 la fin de la descente nous atteignons pour la premi\u00E8re fois la route, la vraie, la SP251 qui m\u00E8ne au col Agnel. c\u00F4t\u00E9 Italie. Nous l\u2019empruntons sur un peu moins d\u2019 un kilom\u00E8tre puis environ 300 m\u00E8tres avant le lacet, il faut prendre \u00E0 gauche dans l\u2019alpage sur un sentier qui part vers l\u2019ouest en direction du col de St V\u00E9ran. La sente est parfois peu marqu\u00E9e mais le cheminement \u00E0 travers l\u2019alpage est assez \u00E9vident.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "La mont\u00E9e est r\u00E9guli\u00E8re mais elle se fait bien sentir (700m de D+ \u00E0 monter depuis la route tout de m\u00EAme !). Nous sommes encourag\u00E9es dans l\u2019effort par de sympathiques vaches pendant une grande partie du chemin. Nous nous \u00E9levons petit \u00E0 petit au-dessus de l\u2019alpage et l\u2019ambiance devient plus min\u00E9rale au fur \u00E0 mesure que le col s\u2019approche.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Arriv\u00E9es au col de St V\u00E9ran (2 843m), nous longeons la cr\u00EAte vers le sud pour r\u00E9cup\u00E9rer peu apr\u00E8s un sentier cairn\u00E9 qui part vers l\u2019ouest en direction des Lacs Blanchet (de m\u00E9moire les lacs ne sont pas indiqu\u00E9s sur les panneaux).\r\n"
                                                        + //
                                                        "Nous atteignons enfin le lac Blanchet Sup\u00E9rieur \u00E0 temps pour le coucher du soleil. Un spot magnifique avec la T\u00EAte des Toillies (3 175m) qui se refl\u00E8te dans le lac.",
                                        article15);
                        Paragraph art15paragraph9 = new Paragraph(
                                        "JOUR 6 : Lac Blanchet sup\u00E9rieur - Col Agnel par le Col de Chamoussi\u00E8re",
                                        'P',
                                        "\\r\\n" + //
                                                        "\" + //\r\n" + //
                                                        "                                                        \"Distance : 6 km\\r\\n"
                                                        + //
                                                        "\" + //\r\n" + //
                                                        "                                                        \"D\\u00E9nivel\\u00E9 positif : 500 m\\r\\n"
                                                        + //
                                                        "\" + //\r\n" + //
                                                        "                                                        \"D\\u00E9nivel\\u00E9 n\\u00E9gatif : 500 m\\r\\n"
                                                        + //
                                                        "\" + //\r\n" + //
                                                        "                                                        \"Le dernier jour sera tr\\u00E8s soft compar\\u00E9 aux pr\\u00E9c\\u00E9dents ! Normal, il faut aussi compter les 4 heures de voiture pour rentrer !\\r\\n"
                                                        + //
                                                        "\"\r\n" + //
                                                        "                                                        + //\r\n"
                                                        + //
                                                        "                                                        \"\\r\\n"
                                                        + //
                                                        "\" + //\r\n" + //
                                                        "                                                        \"Nous partons relativement tard de notre bivouac. Nous r\\u00E9cup\\u00E9rons le sentier qui descend vers le lac Blanchet Inf\\u00E9rieur puis continuons \\u00E0 descendre jusqu\\u2019au refuge de la Blanche. Arriv\\u00E9es au refuge nous prenons un sentier qui s\\u2019\\u00E9l\\u00E8ve au nord est en direction du Col de Chamoussi\\u00E8re (2 882m). Jusqu\\u2019au col c\\u2019est facile, c\\u2019est plus ou moins tout droit m\\u00EAme si la sente est peu marqu\\u00E9e par endroit, le cheminement se devinant facilement car on a rapidement le col en vue.",
                                        article15);
                        Paragraph art15paragraph10 = new Paragraph(
                                        "Epilogue",
                                        'C',
                                        "Arriv\u00E9es au col, nous apercevons enfin la route qui m\u00E8ne au col Agnel et nous entamons la descente finale. \r\n"
                                                        + //
                                                        "Quelques m\u00E8tres de d\u00E9nivel\u00E9 positif viennent nous surprendre sur la fin pour rejoindre la route puis la voiture... \r\n"
                                                        + //
                                                        "et c\u2019est la fin de ce nouveau p\u00E9riple automnal riche en d\u00E9nivel\u00E9 et en rebondissements !",
                                        article15);
                        Paragraph art16paragraph1 = new Paragraph(
                                        "D\u00E9finition",
                                        'I',
                                        "La glyc\u00E9mie, appel\u00E9e aussi \"taux de sucre\" ou \"taux de glucose\" dans le sang, peut varier aussi chez la personne diab\u00E9tique pour plusieurs raisons : \n"
                                                        + //
                                                        "alimentation, traitement, activit\u00E9 physique intense, stress, \u00E9motions...\n"
                                                        + //
                                                        "\n" + //
                                                        " Parvenir \u00E0 l'\u00E9quilibre glyc\u00E9mique est essentiel pour bien vivre son diab\u00E8te au quotidien.\n"
                                                        + //
                                                        "Dans le corps, la r\u00E9gulation de la glyc\u00E9mie est assur\u00E9e gr\u00E2ce \u00E0 un \u00E9quilibre permanent entre diff\u00E9rentes substances principalement hormonales.",
                                        article16);
                        Paragraph art16paragraph2 = new Paragraph(
                                        "3 \u00E9tats de la glyc\u00E9mie",
                                        'P',
                                        "Hypoglyc\u00E9mie :\tInf\u00E9rieur \u00E0 0.60g/l\r\n" + //
                                                        "Glyc\u00E9mie normale \u00E0 jeun : entre 0.70g/l et 1.10g/l\r\n"
                                                        + //
                                                        " \t1h30 apr\u00E8s un repas : inf\u00E9rieur \u00E0 1.40g/l\r\n"
                                                        + //
                                                        "Hyperglyc\u00E9mie \u00E0 jeun :\tSup\u00E9rieur \u00E0 1.10g/l",
                                        article16);
                        Paragraph art16paragraph3 = new Paragraph(
                                        "Substances faisant varier la glyc\u00E9mie",
                                        'P',
                                        "Certaines substances comme l\u2019insuline font diminuer la glyc\u00E9mie, tandis que d'autres, comme le glucagon, l\u2019adr\u00E9naline ou l\u2019hormone de croissance, la font augmenter. \r\n"
                                                        + //
                                                        "L'alimentation et l'activit\u00E9 physique influent \u00E9galement sur la glyc\u00E9mie.",
                                        article16);
                        Paragraph art16paragraph4 = new Paragraph(
                                        "Circonstances de variation",
                                        'P',
                                        "Dans certaines circonstances, la glyc\u00E9mie peut varier tr\u00E8s fortement. \r\n"
                                                        + //
                                                        "Une activit\u00E9 physique intense peut conduire \u00E0 une hypoglyc\u00E9mie (car le simple fait de bouger contribue \u00E0 faire baisser la glyc\u00E9mie). \r\n"
                                                        + //
                                                        "Certaines sensations et \u00E9motions fortes (infection, douleur, stress, joie ou tristesse intenses (\u00E0 l'annonce d'une bonne ou mauvaise nouvelle, par exemple) font, \r\n"
                                                        + //
                                                        "au contraire, monter la glyc\u00E9mie. Et oui, m\u00EAme le coup de foudre peut \u00EAtre hyperglyc\u00E9miant !",
                                        article16);
                        Paragraph art16paragraph5 = new Paragraph(
                                        "D\u00E9faillances du syst\u00E8me",
                                        'P',
                                        "Chez une personne non diab\u00E9tique, le pancr\u00E9as produit de l'insuline en fonction des variations de la glyc\u00E9mie. \r\n"
                                                        + //
                                                        "Il existe ainsi un syst\u00E8me de s\u00E9curit\u00E9 qui \u00E9vite \u00E0 la glyc\u00E9mie de descendre trop bas. \r\n"
                                                        + //
                                                        "Mais pour une personne diab\u00E9tique, ce syst\u00E8me de s\u00E9curit\u00E9 doit \u00EAtre ajust\u00E9 en permanence, quel que soit son traitement. \r\n"
                                                        + //
                                                        "Attention cependant, une prise trop importante d\u2019insuline peut provoquer une hypoglyc\u00E9mie, et une quantit\u00E9 insuffisante peut conduire \u00E0 une hyperglyc\u00E9mie. \r\n"
                                                        + //
                                                        "Le dosage des m\u00E9dicaments chez les personnes atteintes de diab\u00E8te est donc fondamental pour l\u2019\u00E9quilibre glyc\u00E9mique.",
                                        article16);
                        Paragraph art16paragraph6 = new Paragraph(
                                        "Et les glyc\u00E9mies jouent au yoyo... ",
                                        'C',
                                        "Parfois, le corps ne r\u00E9agit pas comme d\u2019habitude et les glyc\u00E9mies jouent au yoyo. \r\n"
                                                        + //
                                                        "Il faut apprendre \u00E0 bien se conna\u00EEtre gr\u00E2ce \u00E0 l\u2019autosurveillance glyc\u00E9mique et \u00E0 l'\u00E9change d\u2019observations avec son m\u00E9decin. \r\n"
                                                        + //
                                                        "Hyperglyc\u00E9mies et hypoglyc\u00E9mies peuvent faire peur (surtout les secondes). Il faut en comprendre les origines pour mieux les corriger et les anticiper.\r\n"
                                                        + //
                                                        "\r\n" + //
                                                        "Les contr\u00F4les r\u00E9guliers permettent de surveiller ces variations. \r\n"
                                                        + //
                                                        "En adoptant les bonnes conduites, vous \u00E9viterez plus facilement les hypoglyc\u00E9mies et les hyperglyc\u00E9mies.",
                                        article16);
                        Paragraph art2paragraph1 = new Paragraph(
                                        "La Maison du Diab\u00E8te",
                                        'I',
                                        "Renforcement des liens entre employeurs et salari\u00E9s, obligations l\u00E9gales, enjeu de certification, lutte contre l\u2019absent\u00E9isme \u2026\r\n"
                                                        + //
                                                        "La pr\u00E9vention et la promotion de la sant\u00E9 en entreprise sont un enjeu de croissance durable.",
                                        article2);
                        Paragraph art2paragraph2 = new Paragraph(
                                        "Comp\u00E9tences et expertise",
                                        'P',
                                        "Nous mettons \u00E0 disposition nos comp\u00E9tences et notre expertise en \u00E9ducation et promotion de la sant\u00E9 afin de rendre accessibles les d\u00E9marches de pr\u00E9vention sant\u00E9 en entreprise.\r\n"
                                                        + //
                                                        "A l\u2019\u00E9coute du grand public, nous avons pour objectif de compl\u00E9ter la d\u00E9marche \u00E9ducative et pr\u00E9ventive des structures sociales (centres sociaux, associations sportives, associations de parents \u2026), en s\u2019appuyant sur diverses activit\u00E9s.\r\n"
                                                        + //
                                                        "Nous avons la volont\u00E9 d\u2019aller \u00E0 la rencontre de la population, en sillonnant chaque route des Hauts-de-France, gr\u00E2ce \u00E0 son Bus Sant\u00E9 notamment.",
                                        article2);
                        Paragraph art2paragraph3 = new Paragraph(
                                        "Une maison \u00E0 votre service",
                                        'C',
                                        "Passez nous rendre visite ...",
                                        article2);
                        Paragraph art3paragraph1 = new Paragraph(
                                        "Le Bus Sant\u00E9 sillonne nos routes ",
                                        'I',
                                        "Les Conseiller-es Pr\u00E9vention Sant\u00E9 (infirmi\u00E8re, di\u00E9t\u00E9ticiennes, professeurs d\u2019activit\u00E9 physique adapt\u00E9e et sophrologue) sont \u00E0 votre \u00E9coute au sein du Bus Sant\u00E9",
                                        article3);
                        Paragraph art3paragraph2 = new Paragraph(
                                        "Pour un d\u00E9pistage proactif ",
                                        'P',
                                        "Ils vous proposent un accompagnement, des conseils adapt\u00E9s sur diff\u00E9rentes th\u00E9matiques (alimentation, activit\u00E9 physique, bien-\u00EAtre, sommeil), \r\n"
                                                        + //
                                                        "une orientation / relais vers des structures locales\u2026 , et des d\u00E9pistages du diab\u00E8te (glyc\u00E9mie capillaire), de la maladie r\u00E9nale chronique (test urinaire) \r\n"
                                                        + //
                                                        "et des maladies cardio-vasculaires (prise de tension art\u00E9rielle).",
                                        article3);
                        Paragraph art3paragraph3 = new Paragraph(
                                        "Un v\u00E9ritable partenariat",
                                        'C',
                                        "Le Bus Sant\u00E9 intervient en partenariat avec les collectivit\u00E9s, les entreprises,\u2026  sur la R\u00E9gion Hauts-de-France.",
                                        article3);
                        Paragraph art4paragraph1 = new Paragraph(
                                        "Maison du diab\u00E8te : la pr\u00E9vention en actions !",
                                        'I',
                                        "Pour une approche pluri-disciplinaire ! ",
                                        article4);
                        Paragraph art4paragraph2 = new Paragraph(
                                        "Une \u00E9quipe de choc",
                                        'P',
                                        "Compos\u00E9e de professionnels form\u00E9s aux actions de pr\u00E9vention et d\u2019\u00E9ducation \r\n"
                                                        + //
                                                        "(conseill\u00E8res en pr\u00E9vention sant\u00E9 de formation infirmi\u00E8re et di\u00E9t\u00E9ticienne ainsi que des professeurs d\u2019Activit\u00E9 Physique Adapt\u00E9e), \r\n"
                                                        + //
                                                        "l\u2019\u00E9quipe de la Maison du diab\u00E8te et des maladies chroniques assure les missions suivantes :\r\n"
                                                        + //
                                                        "accueil individuel et information,\r\n" + //
                                                        "s\u00E9ances de d\u00E9pistage,\r\n" + //
                                                        "actions de pr\u00E9vention des maladies chroniques et de leurs complications,\r\n"
                                                        + //
                                                        "actions de sensibilisation aux comportements favorables \u00E0 la sant\u00E9.\r\n"
                                                        + //
                                                        "",
                                        article4);
                        Paragraph art4paragraph3 = new Paragraph(
                                        "Des ateliers pratiques",
                                        'P',
                                        "Ateliers th\u00E9matiques collectifs (alimentation, facteurs de risques, hygi\u00E8ne de vie\u2026),\r\n"
                                                        + //
                                                        "s\u00E9ances de relaxation/automassage et d\u2019activit\u00E9 physique,\r\n"
                                                        + //
                                                        "formation et information des professionnels de sant\u00E9.\r\n"
                                                        + //
                                                        "Afin de compl\u00E9ter sa d\u00E9marche \u00E9ducative, la Maison du diab\u00E8te et des maladies chroniques oriente les usagers \r\n"
                                                        + //
                                                        "et s\u2019appuie sur les activit\u00E9s et le savoir-faire des structures locales : \r\n"
                                                        + //
                                                        "centres sociaux, associations sportives, association de patients, r\u00E9seaux de sant\u00E9 existants\u2026",
                                        article4);
                        Paragraph art4paragraph4 = new Paragraph(
                                        "Nos brochures d'information",
                                        'C',
                                        "Consultez notre documentation et prenez de bonnes habitudes au service d'une bonne hygi\u00E8ne de vie !",
                                        article4);
                        Paragraph art5paragraph1 = new Paragraph(
                                        "Salade de harengs aux lentilles",
                                        'I',
                                        "Simple, nutritionnel et go\u00FBteux...un petit plat qui vous surprendra !",
                                        article5);
                        Paragraph art5paragraph2 = new Paragraph(
                                        "Pr\u00E9paration",
                                        'P',
                                        "Faire cuire les lentilles dans une grande quantit\u00E9 d\u2019eau pendant 20 \u00E0 25 min environ.D\u00E9marrer la cuisson \u00E0 l\u2019eau froide et saler \u00E0 mi-cuisson. \r\n"
                                                        + //
                                                        "\u00C9goutter les lentilles lorsqu\u2019elles sont cuites.\u00C9plucher les \u00E9chalotes, les couper finement. \r\n"
                                                        + //
                                                        "Dans un bol, m\u00E9langer l\u2019huile, le vinaigre, le miel et les \u00E9chalotes. \r\n"
                                                        + //
                                                        "Saler, poivrer.Verser la sauce sur les lentilles. \r\n" + //
                                                        "M\u00E9langer.Mettre les lentilles dans un plat. \r\n" + //
                                                        "D\u00E9poser les filets de hareng \u00E9goutt\u00E9s au-dessus.Parsemer de persil cisel\u00E9.",
                                        article5);
                        Paragraph art5paragraph3 = new Paragraph(
                                        "Une variante",
                                        'C',
                                        "Cette salade peut \u00EAtre pr\u00E9par\u00E9e \u00E9galement avec du haddock mais le co\u00FBt sera plus \u00E9lev\u00E9.\r\n"
                                                        + //
                                                        "Bon app\u00E9tit !",
                                        article5);
                        Paragraph art6paragraph1 = new Paragraph(
                                        "Quid ?",
                                        'I',
                                        "Sport de raquette, le badminton oppose 2 joueurs ou deux \u00E9quipes de 2 joueurs s\u00E9par\u00E9s par un filet et se joue g\u00E9n\u00E9ralement en salle.",
                                        article6);
                        Paragraph art6paragraph2 = new Paragraph(
                                        "Objectifs et r\u00E8gles",
                                        'P',
                                        "Le but est de frapper un volant de mani\u00E8re \u00E0 le faire tomber dans le demi-terrain adverse, ou d\u2019obliger ses adversaires \u00E0 commettre une faute.\r\n"
                                                        + //
                                                        "Ce sport d\u2019endurance fait travailler les muscles et particuli\u00E8rement ceux des jambes, des fessiers et des bras.\r\n"
                                                        + //
                                                        "Il am\u00E9liore la coordination et l\u2019\u00E9quilibre, par sa grande vari\u00E9t\u00E9 de mouvements.",
                                        article6);
                        Paragraph art6paragraph3 = new Paragraph(
                                        "Equipement",
                                        'P',
                                        "Il vous faut une raquette, un volant et des chaussures adapt\u00E9es : souples et l\u00E9g\u00E8res, avec une semelle en gomme. \r\n"
                                                        + //
                                                        "Ajoutez-y un tee-shirt assorti d\u2019un short (les femmes peuvent opter pour une jupe ou une robe).\r\n"
                                                        + //
                                                        "Il n\u2019est pas indispensable d\u2019\u00EAtre dans un club pour pratiquer le badminton, vous pouvez tout \u00E0 fait vous achetez des raquettes et jouer dans votre jardin, sur la page\u2026\r\n"
                                                        + //
                                                        "",
                                        article6);
                        Paragraph art6paragraph4 = new Paragraph(
                                        "Le saviez-vous ?",
                                        'C',
                                        "Le badminton est le sport de raquette le plus rapide du monde : le volant peut en effet atteindre une vitesse de 300 km/h lors d\u2019un smash. \r\n"
                                                        + //
                                                        "Le record actuel en comp\u00E9tition s\u2019\u00E9l\u00E8ve \u00E0 la vitesse impressionnante de 332 km/h.",
                                        article6);
                        Paragraph art7paragraph1 = new Paragraph(
                                        "Bien manger sans se ruiner !",
                                        'I',
                                        "Les l\u00E9gumes secs ne sont pas si longs \u00E0 pr\u00E9parer...",
                                        article7);
                        Paragraph art7paragraph2 = new Paragraph(
                                        "Quelques conseils",
                                        'P',
                                        "Par exemple, les lentilles et les pois cass\u00E9s n\u2019ont pas besoin de trempage. \r\n"
                                                        + //
                                                        "Les haricots secs, les pois chiches et les f\u00E8ves n\u00E9cessitent de tremper au moins 12h avant cuisson, \r\n"
                                                        + //
                                                        "mais si vous n\u2019avez pas le temps, vous pouvez les trouver pr\u00E9cuits en bocaux ou en conserves, pr\u00EAts \u00E0 r\u00E9chauffer ou encore surgel\u00E9s.\r\n"
                                                        + //
                                                        "Un dahl de lentilles, un chili sin carne avec des haricots rouges ou encore des beignets de pois chiches\u2026 Il y en a pour tous les go\u00FBts, et tout \u00E7a sans se ruiner !\r\n"
                                                        + //
                                                        "Riz complet, p\u00E2tes et semoule compl\u00E8tes\u2026 Vous aimez ? Tant mieux, car ils sont beaucoup plus riches en fibres que les produits raffin\u00E9s et sont \u00E9galement bon march\u00E9. \r\n"
                                                        + //
                                                        "Par exemple pr\u00E9f\u00E9rez le pain complet au pain blanc.  Il est recommand\u00E9 de manger des f\u00E9culents complets au moins une fois par jour.\r\n"
                                                        + //
                                                        "P\u00E2tes compl\u00E8tes courgettes pesto, curry de pois chiches et riz complet, semoule au lait \u00E0 la fleur d\u2019oranger\u2026\r\n"
                                                        + //
                                                        "Profitons aussi des produits de saison souvent moins chers. Les prix peuvent varier d\u2019une ann\u00E9e sur l\u2019autre en fonction des r\u00E9coltes \r\n"
                                                        + //
                                                        "mais les fruits et l\u00E9gumes de saison ont souvent le meilleur rapport qualit\u00E9-prix. \r\n"
                                                        + //
                                                        "En plus cela \u00E9vite qu\u2019ils ne poussent sous des serres chauff\u00E9es et peuvent \u00EAtre cultiv\u00E9s sous nos latitudes, \r\n"
                                                        + //
                                                        "c\u2019est meilleur pour la plan\u00E8te.\r\n" + //
                                                        "",
                                        article7);
                        Paragraph art7paragraph3 = new Paragraph(
                                        "Certes ils sont souvent plus chers",
                                        'C',
                                        "Le bio permet de manger des produits sans trace de pesticides. \r\n" + //
                                                        "Mais en mangeant moins de viande, moins de produits transform\u00E9s et plus d\u2019aliments de saison, votre porte-monnaie s\u2019y retrouve!",
                                        article7);
                        Paragraph art8paragraph1 = new Paragraph(
                                        "Un point du globe ",
                                        'I',
                                        "Sucre,  c'est aussi le nom d'une ville !",
                                        article8);
                        Paragraph art8paragraph2 = new Paragraph(
                                        "Escapade en Bolivie",
                                        'P',
                                        "Sucre (prononc\u00E9 su.k\u027Ee) est la capitale constitutionnelle de la Bolivie. \r\n"
                                                        + //
                                                        "Elle est \u00E9galement la capitale du d\u00E9partement de Chuquisaca et le chef-lieu de la province d'Oropeza. \r\n"
                                                        + //
                                                        "",
                                        article8);
                        Paragraph art8paragraph3 = new Paragraph(
                                        "D\u00E9mographie",
                                        'C',
                                        "Sa population s'\u00E9l\u00E8ve \u00E0 259 388 habitants lors du recensement bolivien de 2012.",
                                        article8);
                        Paragraph art9paragraph1 = new Paragraph(
                                        "Incontournable sucre ",
                                        'I',
                                        "Le sucre joue un r\u00F4le majeur dans l'\u00E9conomie mondiale, contribuant \u00E0 la croissance \u00E9conomique et \u00E0 la cr\u00E9ation d'emplois. \r\n"
                                                        + //
                                                        "En tant que produit agricole et ingr\u00E9dient cl\u00E9 de nombreuses industries, le sucre g\u00E9n\u00E8re des opportunit\u00E9s commerciales et stimule le d\u00E9veloppement \u00E9conomique. \r\n"
                                                        + //
                                                        "Dans cet article, nous explorerons bri\u00E8vement l'impact \u00E9conomique du sucre.",
                                        article9);
                        Paragraph art9paragraph2 = new Paragraph(
                                        "Une production lucrative",
                                        'P',
                                        "La production mondiale de sucre repr\u00E9sente un secteur \u00E9conomique lucratif. \r\n"
                                                        + //
                                                        "Les pays producteurs, tels que le Br\u00E9sil, l'Inde et la Tha\u00EFlande, exportent leur sucre vers d'autres r\u00E9gions du monde, cr\u00E9ant des flux commerciaux importants. \r\n"
                                                        + //
                                                        "Cette activit\u00E9 soutient les revenus nationaux et favorise la prosp\u00E9rit\u00E9 \u00E9conomique.",
                                        article9);
                        Paragraph art9paragraph3 = new Paragraph(
                                        "Cr\u00E9ation d'emplois",
                                        'P',
                                        "L'industrie sucri\u00E8re offre des opportunit\u00E9s d'emploi dans les zones rurales, o\u00F9 la canne \u00E0 sucre est cultiv\u00E9e et r\u00E9colt\u00E9e. \r\n"
                                                        + //
                                                        "De la plantation \u00E0 la transformation, de nombreux travailleurs sont impliqu\u00E9s dans la cha\u00EEne de valeur du sucre. \r\n"
                                                        + //
                                                        "Ces emplois contribuent \u00E0 r\u00E9duire la pauvret\u00E9 et \u00E0 am\u00E9liorer les conditions de vie dans les communaut\u00E9s agricoles.",
                                        article9);
                        Paragraph art9paragraph4 = new Paragraph(
                                        "Industries connexes",
                                        'P',
                                        "Le sucre est un ingr\u00E9dient essentiel dans de nombreuses industries, telles que l'industrie alimentaire, les boissons et les confiseries. \r\n"
                                                        + //
                                                        "Ces secteurs d\u00E9pendent du sucre pour la production de leurs produits. \r\n"
                                                        + //
                                                        "Ainsi, l'industrie sucri\u00E8re soutient \u00E9galement la croissance \u00E9conomique dans ces industries connexes.",
                                        article9);
                        Paragraph art9paragraph5 = new Paragraph(
                                        "Bien plus qu'un simple ingr\u00E9dient sucr\u00E9 !",
                                        'C',
                                        "Le sucre a un impact significatif sur l'\u00E9conomie mondiale. \r\n" + //
                                                        "En tant que moteur \u00E9conomique, il g\u00E9n\u00E8re des revenus importants, cr\u00E9e des emplois et soutient le d\u00E9veloppement \u00E9conomique des pays producteurs. \r\n"
                                                        + //
                                                        "Le sucre est bien plus qu'un simple ingr\u00E9dient sucr\u00E9 ; il est un acteur cl\u00E9 dans la prosp\u00E9rit\u00E9 \u00E9conomique \u00E0 l'\u00E9chelle mondiale.",
                                        article9);
                        Paragraph art17paragraph1 = new Paragraph(
                                        "Introduction",
                                        'I',
                                        "L'expression \"sugar rush\" (ru\u00E9e de sucre) est souvent utilis\u00E9e pour d\u00E9crire une sensation d'\u00E9nergie intense et soudaine apr\u00E8s avoir consomm\u00E9 une grande quantit\u00E9 de sucre. Beaucoup de gens croient que manger des sucreries ou boire des boissons sucr\u00E9es peut entra\u00EEner ce ph\u00E9nom\u00E8ne \u00E9nerg\u00E9tique, mais qu'en est-il vraiment ? Est-ce un v\u00E9ritable effet physiologique ou simplement un mythe ? Dans cet article, nous allons examiner de plus pr\u00E8s ce que la science nous dit \u00E0 ce sujet.",
                                        article17);
                        Paragraph art17paragraph2 = new Paragraph(
                                        "Le Sucre et l'\u00C9nergie",
                                        'P',
                                        "Pour comprendre l'effet potentiel du sucre sur notre niveau d'\u00E9nergie, il est essentiel de savoir comment notre corps traite cette substance. Le sucre, ou glucose, est une source importante d'\u00E9nergie pour notre organisme. Lorsque nous consommons des aliments riches en glucides, comme les bonbons, les g\u00E2teaux ou les boissons sucr\u00E9es, notre corps d\u00E9compose ces glucides en glucose. Le glucose est ensuite absorb\u00E9 par notre sang et utilis\u00E9 par nos cellules pour produire de l'\u00E9nergie.",
                                        article17);
                        Paragraph art17paragraph3 = new Paragraph(
                                        "Coup de Pouce \u00C9nerg\u00E9tique ?",
                                        'P',
                                        "Selon certaines croyances populaires, une consommation importante de sucre entra\u00EEnerait une mont\u00E9e d'\u00E9nergie rapide, voire euphorique, connue sous le nom de \"sugar rush\". Cependant, les preuves scientifiques \u00E0 l'appui de cette th\u00E9orie sont limit\u00E9es. Des \u00E9tudes ont \u00E9t\u00E9 men\u00E9es pour \u00E9valuer l'effet du sucre sur l'humeur, la concentration et les niveaux d'\u00E9nergie. Une m\u00E9ta-analyse publi\u00E9e dans le \"British Journal of Nutrition\" a conclu qu'il n'y a pas de preuve significative pour soutenir l'id\u00E9e d'un \"sugar rush\". Les chercheurs ont constat\u00E9 que, bien que le sucre puisse provoquer une augmentation rapide de la glyc\u00E9mie, cette augmentation est rapidement suivie d'une baisse, ce qui peut entra\u00EEner une sensation de fatigue et de l\u00E9thargie.",
                                        article17);
                        Paragraph art17paragraph4 = new Paragraph(
                                        "La R\u00E9alit\u00E9 : Le Crash de Sucre / Facteurs Psychologiques",
                                        'P',
                                        "Plut\u00F4t que de provoquer un pic d'\u00E9nergie, la consommation excessive de sucre peut entra\u00EEner un \"crash de sucre\". Lorsque le taux de sucre dans le sang diminue rapidement apr\u00E8s une hausse temporaire, cela peut entra\u00EEner une sensation de faiblesse, de fatigue et de mauvaise humeur. C'est ce qu'on appelle commun\u00E9ment la \"gueule de bois du sucre\". L'effet ressenti apr\u00E8s la consommation de sucre peut \u00E9galement \u00EAtre influenc\u00E9 par des facteurs psychologiques. Certaines personnes peuvent anticiper un regain d'\u00E9nergie apr\u00E8s avoir mang\u00E9 des sucreries, ce qui peut cr\u00E9er un effet placebo. Cela signifie que leur cerveau anticipe une augmentation d'\u00E9nergie, m\u00EAme si elle n'est pas vraiment due au sucre.",
                                        article17);
                        Paragraph art17paragraph5 = new Paragraph(
                                        "Conclusion",
                                        'C',
                                        "En conclusion, l'effet \"sugar rush\" est davantage un mythe qu'une r\u00E9alit\u00E9 scientifique. Bien que la consommation de sucre puisse entra\u00EEner une augmentation temporaire de l'\u00E9nergie, cette hausse est souvent suivie d'une chute rapide, conduisant \u00E0 une sensation de fatigue. Plut\u00F4t que de chercher \u00E0 obtenir une mont\u00E9e d'\u00E9nergie \u00E9ph\u00E9m\u00E8re, il est pr\u00E9f\u00E9rable de maintenir une alimentation \u00E9quilibr\u00E9e pour b\u00E9n\u00E9ficier d'une \u00E9nergie constante tout au long de la journ\u00E9e. Alors, la prochaine fois que vous atteindrez le paquet de bonbons en esp\u00E9rant un \"sugar rush\", rappelez-vous que la mod\u00E9ration est la cl\u00E9 pour une sant\u00E9 optimale.",
                                        article17);
                        Paragraph art18paragraph1 = new Paragraph(
                                        "Introduction",
                                        'I',
                                        "Les Dragibus Haribo sont depuis longtemps des incontournables de l'univers des bonbons. Leurs couleurs vives et leurs formes de lentilles attirent les petits et les grands gourmands. Mais saviez-vous que ces d\u00E9licieux bonbons ne se r\u00E9sument pas \u00E0 une seule et unique saveur ? En r\u00E9alit\u00E9, les Dragibus offrent un v\u00E9ritable arc-en-ciel de go\u00FBts, chacune de leurs couleurs correspondant \u00E0 une saveur diff\u00E9rente. D\u00E9couvrons ensemble la palette de plaisirs gustatifs qu'offrent les Dragibus, ces petites douceurs g\u00E9lifi\u00E9es qui nous font saliver.",
                                        article18);
                        Paragraph art18paragraph2 = new Paragraph(
                                        "Le Spectre des Saveurs",
                                        'P',
                                        "Imaginez plonger la main dans un sac de Dragibus Haribo et en ressortir une poign\u00E9e multicolore. \u00C0 chaque couleur correspond une promesse de saveur unique. Le rouge \u00E9voque la fraise, le jaune le citron p\u00E9tillant, le vert rappelle la douceur de la pomme et le noir vous fait voyager vers les d\u00E9lices du cassis. La palette de ces bonbons iconiques s'\u00E9tend encore plus loin avec des saveurs comme la framboise, l'orange ou m\u00EAme la r\u00E9glisse, offrant une diversit\u00E9 qui rend la d\u00E9gustation toujours surprenante.",
                                        article18);
                        Paragraph art18paragraph3 = new Paragraph(
                                        "Un Voyage Sensoriel",
                                        'P',
                                        "La vari\u00E9t\u00E9 des saveurs des Dragibus Haribo ouvre la porte \u00E0 un voyage sensoriel inattendu \u00E0 chaque bouch\u00E9e. Quel plaisir de go\u00FBter successivement la douceur fruit\u00E9e de la fraise, la l\u00E9g\u00E8re acidit\u00E9 de l'orange, puis la fra\u00EEcheur du citron. Ces bonbons multicolores satisfont ainsi toutes les envies et permettent \u00E0 chacun de trouver sa combinaison pr\u00E9f\u00E9r\u00E9e. Certains aimeront le c\u00F4t\u00E9 acidul\u00E9 des couleurs jaunes et oranges, tandis que d'autres pr\u00E9f\u00E9reront se d\u00E9lecter des notes sucr\u00E9es des couleurs rouges et roses.",
                                        article18);
                        Paragraph art18paragraph4 = new Paragraph(
                                        "Conclusion",
                                        'C',
                                        "En conclusion, les Dragibus Haribo ne se contentent pas d'\u00EAtre de simples bonbons, ils sont de v\u00E9ritables invitations \u00E0 la d\u00E9couverte de multiples saveurs. Leur palette gustative \u00E9tendue offre une exp\u00E9rience sensorielle unique \u00E0 chaque d\u00E9gustation, faisant ainsi le bonheur des papilles des petits et des grands. Alors, la prochaine fois que vous plongerez la main dans un sachet de Dragibus, prenez le temps de savourer chaque couleur et de vous laisser emporter par ce tourbillon de go\u00FBts. Car avec les Dragibus Haribo, c'est un v\u00E9ritable arc-en-ciel de plaisirs g\u00E9lifi\u00E9s qui s'offre \u00E0 vous !",
                                        article18);
                        Paragraph art19paragraph1 = new Paragraph(
                                        "Introduction",
                                        'I',
                                        "Depuis des si\u00E8cles, le sucre a \u00E9t\u00E9 l'une des denr\u00E9es les plus pr\u00E9cieuses et recherch\u00E9es \u00E0 travers le monde. Son r\u00F4le en tant qu'ingr\u00E9dient essentiel dans l'alimentation humaine a fait du sucre un bien d'une importance \u00E9conomique consid\u00E9rable. Au fil du temps, la demande croissante et la valeur \u00E9conomique du sucre ont conduit \u00E0 la cr\u00E9ation d'un march\u00E9 financier d\u00E9di\u00E9 \u00E0 sa cotation en bourse. Dans cet article, nous explorerons l'histoire fascinante de la cotation du sucre en bourse, des d\u00E9buts de ce march\u00E9 jusqu'\u00E0 son \u00E9volution contemporaine.",
                                        article19);
                        Paragraph art19paragraph2 = new Paragraph(
                                        "Les origines du commerce du sucre",
                                        'P',
                                        "L'histoire du sucre remonte \u00E0 l'Antiquit\u00E9, lorsque la canne \u00E0 sucre \u00E9tait cultiv\u00E9e en Inde et en Chine depuis plus de 2 000 ans. Au fil du temps, l'utilisation du sucre s'est r\u00E9pandue dans le monde arabe et en Europe gr\u00E2ce aux routes commerciales \u00E9tablies pendant l'\u00E8re m\u00E9di\u00E9vale. Les croisades ont \u00E9galement jou\u00E9 un r\u00F4le majeur dans l'introduction du sucre en Europe, o\u00F9 il est devenu rapidement un produit de luxe r\u00E9serv\u00E9 \u00E0 l'\u00E9lite.",
                                        article19);
                        Paragraph art19paragraph3 = new Paragraph(
                                        "L'\u00E9mergence des bourses du sucre",
                                        'P',
                                        "Les premi\u00E8res bourses du sucre ont vu le jour au d\u00E9but du 20e si\u00E8cle. En 1914, la New York Coffee and Sugar Exchange (Bourse du caf\u00E9 et du sucre de New York) a \u00E9t\u00E9 cr\u00E9\u00E9e, suivie en 1919 par la London Sugar Clearing House (Chambre de compensation du sucre de Londres). Ces bourses fournissaient un cadre o\u00F9 les producteurs, les n\u00E9gociants et les consommateurs pouvaient acheter et vendre des contrats \u00E0 terme de sucre, \u00E9tablissant ainsi un prix standardis\u00E9 pour cette marchandise.",
                                        article19);
                        Paragraph art19paragraph4 = new Paragraph(
                                        "L'\u00E9volution de la cotation du sucre en bourse",
                                        'P',
                                        "Au fur et \u00E0 mesure que l'industrie sucri\u00E8re se d\u00E9veloppait et que la demande mondiale augmentait, la cotation du sucre en bourse est devenue de plus en plus sophistiqu\u00E9e. Les bourses du sucre ont int\u00E9gr\u00E9 des avanc\u00E9es technologiques pour faciliter les transactions et acc\u00E9l\u00E9rer les processus. Les contrats \u00E0 terme \u00E0 \u00E9ch\u00E9ance ont \u00E9t\u00E9 introduits, permettant aux acteurs du march\u00E9 de se prot\u00E9ger contre les fluctuations de prix futures du sucre.",
                                        article19);
                        Paragraph art19paragraph5 = new Paragraph(
                                        "Conclusion",
                                        'C',
                                        "La cotation du sucre en bourse a parcouru un long chemin depuis ses modestes d\u00E9buts au d\u00E9but du 20e si\u00E8cle. Aujourd'hui, elle joue un r\u00F4le essentiel dans l'industrie sucri\u00E8re mondiale, en permettant aux acteurs du march\u00E9 de se couvrir contre les risques de volatilit\u00E9 des prix et en facilitant le commerce \u00E0 grande \u00E9chelle. L'histoire de la cotation du sucre en bourse t\u00E9moigne de l'importance \u00E9conomique du sucre et de son statut de denr\u00E9e pr\u00E9cieuse qui continue de nourrir nos soci\u00E9t\u00E9s depuis des si\u00E8cles.",
                                        article19);
                        Paragraph art20paragraph1 = new Paragraph(
                                        "Introduction",
                                        'I',
                                        "Le pop-corn, ce snack croustillant et d\u00E9licieux, a longtemps \u00E9t\u00E9 l'un des plaisirs incontournables des cin\u00E9mas, des parcs d'attractions et des f\u00EAtes. Cependant, ces derni\u00E8res ann\u00E9es, son co\u00FBt a connu une inflation alarmante, posant ainsi des d\u00E9fis \u00E9conomiques et sociaux pour les amateurs de cette friandise.",
                                        article20);
                        Paragraph art20paragraph2 = new Paragraph(
                                        "L'essor du pop-corn dans la culture de consommation",
                                        'P',
                                        "Le pop-corn a une longue histoire qui remonte \u00E0 des milliers d'ann\u00E9es, mais c'est au 20\u00E8me si\u00E8cle qu'il est devenu un symbole embl\u00E9matique de la culture de consommation moderne. Dans les ann\u00E9es 1930, avec la popularit\u00E9 croissante des cin\u00E9mas, le ma\u00EFs souffl\u00E9 a rapidement trouv\u00E9 sa place en tant que collation incontournable pour les cin\u00E9philes. Les vendeurs ambulants et les stands de pop-corn ont commenc\u00E9 \u00E0 appara\u00EEtre dans les rues anim\u00E9es des villes, renfor\u00E7ant ainsi l'image du pop-corn comme une collation pratique et abordable pour tous.",
                                        article20);
                        Paragraph art20paragraph3 = new Paragraph(
                                        "L'impact de l'inflation sur le prix du pop-corn",
                                        'P',
                                        "Cependant, malgr\u00E9 ses origines modestes, le pop-corn n'a pas \u00E9t\u00E9 \u00E9pargn\u00E9 par les fluctuations \u00E9conomiques mondiales, notamment l'inflation. L'inflation se r\u00E9f\u00E8re \u00E0 la hausse g\u00E9n\u00E9rale et durable des prix des biens et des services sur une p\u00E9riode de temps donn\u00E9e. Au fil des ann\u00E9es, divers facteurs ont contribu\u00E9 \u00E0 l'inflation du prix du pop-corn : La demande croissante : La popularit\u00E9 constante du pop-corn comme collation de choix a conduit \u00E0 une augmentation de la demande. Une demande accrue entra\u00EEne souvent une augmentation des prix, car les producteurs cherchent \u00E0 maximiser leurs profits. La volatilit\u00E9 des mati\u00E8res premi\u00E8res : Le pop-corn \u00E9tant fabriqu\u00E9 \u00E0 partir de ma\u00EFs, les fluctuations des prix du ma\u00EFs ont un impact direct sur son co\u00FBt final. Des facteurs tels que les conditions m\u00E9t\u00E9orologiques, les p\u00E9nuries de r\u00E9coltes et les probl\u00E8mes environnementaux peuvent provoquer des variations soudaines des prix du ma\u00EFs. Les co\u00FBts de production : Les d\u00E9penses li\u00E9es \u00E0 la production, au conditionnement et \u00E0 la distribution du pop-corn ont \u00E9galement augment\u00E9. Les producteurs et les d\u00E9taillants doivent faire face \u00E0 des co\u00FBts suppl\u00E9mentaires pour l'\u00E9nergie, la main-d'\u0153uvre et les mat\u00E9riaux d'emballage. L'\u00E9volution du march\u00E9 : L'industrie alimentaire est soumise \u00E0 des pressions concurrentielles constantes. Les entreprises cherchent \u00E0 maintenir leurs marges b\u00E9n\u00E9ficiaires, ce qui peut conduire \u00E0 une augmentation des prix du pop-corn.",
                                        article20);
                        Paragraph art20paragraph4 = new Paragraph(
                                        "Les cons\u00E9quences de l'inflation du pop-corn",
                                        'P',
                                        "L'inflation du pop-corn a des cons\u00E9quences importantes pour les consommateurs et les vendeurs. Pour les consommateurs, l'achat d'un simple sac de pop-corn au cin\u00E9ma ou dans un parc d'attractions peut devenir une d\u00E9pense consid\u00E9rable, en particulier pour les familles nombreuses. Certains peuvent m\u00EAme se tourner vers des alternatives moins co\u00FBteuses, ce qui pourrait entra\u00EEner une baisse de la demande pour cette collation embl\u00E9matique. Pour les vendeurs de pop-corn, l'inflation peut entra\u00EEner des d\u00E9fis op\u00E9rationnels. Ils doivent jongler avec l'augmentation des co\u00FBts tout en restant comp\u00E9titifs sur le march\u00E9. Certains peuvent \u00EAtre contraints de r\u00E9duire la taille des portions ou d'augmenter les prix de mani\u00E8re significative, risquant ainsi de perdre une partie de leur client\u00E8le.",
                                        article20);
                        Paragraph art20paragraph5 = new Paragraph(
                                        "Conclusion",
                                        'C',
                                        "L'inflation du co\u00FBt du pop-corn est un exemple frappant de l'impact \u00E9conomique sur les biens de consommation courants. Alors que cette d\u00E9licieuse collation continue de charmer les papilles des gourmands du monde entier, les d\u00E9fis \u00E9conomiques et les strat\u00E9gies d'adaptation jouent un r\u00F4le essentiel dans son maintien en tant que symbole culturel et gustatif. Seul le temps nous dira comment les producteurs et les consommateurs s'adapteront \u00E0 cette \u00E9volution des prix et si le pop-corn pourra conserver son statut de collation incontournable dans les ann\u00E9es \u00E0 venir.",
                                        article20);
                        Paragraph art21paragraph1 = new Paragraph(
                                        "Introduction",
                                        'I',
                                        "L\u2019hypoglyc\u00E9mie peut survenir au cours d\u2019une activit\u00E9 sportive. Cela engendre chez le sportif une sensation de malaise tr\u00E8s d\u00E9sagr\u00E9able, l\u2019emp\u00EAchant de poursuivre son entra\u00EEnement. L\u2019hypoglyc\u00E9mie se traduit par une chute du taux de glucose dans le sang. Comment l\u2019\u00E9viter ?",
                                        article21);
                        Paragraph art21paragraph2 = new Paragraph(
                                        "Quels sont les sympt\u00F4mes de l\u2019hypoglyc\u00E9mie",
                                        'P',
                                        "On parle d\u2019hypoglyc\u00E9mie lorsque le taux de sucre dans votre sang descend au-dessous de 4 mmol/L. Pour un sportif, le glucose est le principal carburant de son organisme. Et, durant l\u2019effort, son corps en puise progressivement dans sa r\u00E9serve. Si celui-ci vient \u00E0 manquer, alors il peut souffrir d\u2019hypoglyc\u00E9mie. Lorsque cela survient, le sportif peut ressentir soudainement une sensation de fatigue tr\u00E8s profonde, des tremblements, des naus\u00E9es, une faim extr\u00EAme, des \u00E9tourdissements, des sueurs froides, de la nervosit\u00E9, des modifications de la vision, etc. Il n\u2019a plus alors la force de poursuivre son entra\u00EEnement.",
                                        article21);
                        Paragraph art21paragraph3 = new Paragraph(
                                        "Comment faire pour \u00E9viter l\u2019hypoglyc\u00E9mie ?",
                                        'P',
                                        "Une mauvaise alimentation est la premi\u00E8re cause d\u2019hypoglyc\u00E9mie. Si vous avez un entra\u00EEnement sportif \u00E0 effectuer durant la journ\u00E9e, adoptez un comportement alimentaire \u00E9quilibr\u00E9. Consommez des l\u00E9gumes et fruits riches en fibres et mangez des repas contenant des hydrates de carbone complexes comme le riz et les p\u00E2tes. Hydratez-vous \u00E9galement correctement. Sachez aussi que le stress favorise l\u2019hypoglyc\u00E9mie. En effet, quand vous vous trouvez dans un \u00E9tat d\u2019anxi\u00E9t\u00E9, votre organisme produit des hormones qui vont impacter la quantit\u00E9 de sucre dans votre sang. Ainsi, vous devez apprendre \u00E0 mieux g\u00E9rer votre stress. Une hypoglyc\u00E9mie signifie une baisse du niveau du sucre dans le sang. Toutefois, cela ne signifie pas que vous devez consommer une grande quantit\u00E9 de sucre pour l\u2019\u00E9viter. Le sucre repr\u00E9sente aussi un r\u00E9el danger pour votre sant\u00E9. D\u2019ailleurs, avant une s\u00E9ance d\u2019entra\u00EEnement, vous devez \u00E9viter de manger des aliments trop sucr\u00E9s comme les sodas, les g\u00E2teaux, les biscuits et les friandises. Ceux-ci feront grimper votre glyc\u00E9mie. Ce qui va provoquer par la suite un coup de barre durant l\u2019effort. Et, si vous souhaitez entretenir votre sant\u00E9, privil\u00E9giez le sucre de noix de coco au quotidien. Il est plus sain compar\u00E9 au sucre ordinaire. De nombreuses \u00E9tudes ont prouv\u00E9 ses propri\u00E9t\u00E9s incroyables: il est riche en min\u00E9raux et en vitamines. Il contient aussi de l\u2019inuline, une fibre pr\u00E9biotique b\u00E9n\u00E9fique pour la flore intestinale. Durant l\u2019effort, vous pouvez boire par petites gorg\u00E9es une boisson isotonique. Et apr\u00E8s votre s\u00E9ance sportive, ing\u00E9rez des sucres lents (c\u00E9r\u00E9ales, pommes de terre, etc.) et hydratez-vous bien. Mangez aussi des aliments solides riches en glucides comme des p\u00E2tes de fruits ou encore des barres c\u00E9r\u00E9ales.",
                                        article21);
                        Paragraph art21paragraph4 = new Paragraph(
                                        "Que faire en cas d\u2019hypoglyc\u00E9mie ?",
                                        'C',
                                        "Si vous ressentez un malaise durant votre s\u00E9ance sportive, vous devez arr\u00EAter votre activit\u00E9. Puis, consommez rapidement du sucre rapide (bonbon, jus de fruits, etc.). Buvez \u00E9galement une boisson glucidique. Si apr\u00E8s 15 minutes, vous ne ressentez aucun changement, prenez encore des substances sucr\u00E9es. Cela devrait suffire pour rem\u00E9dier \u00E0 la situation. Si ce n\u2019est pas le cas, il faut appeler les urgences ou votre m\u00E9decin. En cas d\u2019hypoglyc\u00E9mie s\u00E9v\u00E8re (perte de conscience), une injection intraveineuse de glucose est n\u00E9cessaire.",
                                        article21);
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
                        paragraphRepository.save(art11paragraph1);
                        paragraphRepository.save(art11paragraph2);
                        paragraphRepository.save(art11paragraph3);
                        paragraphRepository.save(art11paragraph4);
                        paragraphRepository.save(art11paragraph5);
                        paragraphRepository.save(art11paragraph6);
                        paragraphRepository.save(art11paragraph7);
                        paragraphRepository.save(art11paragraph8);
                        paragraphRepository.save(art11paragraph9);
                        paragraphRepository.save(art12paragraph1);
                        paragraphRepository.save(art12paragraph2);
                        paragraphRepository.save(art12paragraph3);
                        paragraphRepository.save(art12paragraph4);
                        paragraphRepository.save(art13paragraph1);
                        paragraphRepository.save(art13paragraph2);
                        paragraphRepository.save(art13paragraph3);
                        paragraphRepository.save(art13paragraph4);
                        paragraphRepository.save(art13paragraph5);
                        paragraphRepository.save(art13paragraph6);
                        paragraphRepository.save(art13paragraph7);
                        paragraphRepository.save(art14paragraph1);
                        paragraphRepository.save(art14paragraph2);
                        paragraphRepository.save(art14paragraph3);
                        paragraphRepository.save(art14paragraph4);
                        paragraphRepository.save(art15paragraph1);
                        paragraphRepository.save(art15paragraph2);
                        paragraphRepository.save(art15paragraph3);
                        paragraphRepository.save(art15paragraph4);
                        paragraphRepository.save(art15paragraph5);
                        paragraphRepository.save(art15paragraph6);
                        paragraphRepository.save(art15paragraph7);
                        paragraphRepository.save(art15paragraph8);
                        paragraphRepository.save(art15paragraph9);
                        paragraphRepository.save(art15paragraph10);
                        paragraphRepository.save(art16paragraph1);
                        paragraphRepository.save(art16paragraph2);
                        paragraphRepository.save(art16paragraph3);
                        paragraphRepository.save(art16paragraph4);
                        paragraphRepository.save(art16paragraph5);
                        paragraphRepository.save(art16paragraph6);
                        paragraphRepository.save(art2paragraph1);
                        paragraphRepository.save(art2paragraph2);
                        paragraphRepository.save(art2paragraph3);
                        paragraphRepository.save(art3paragraph1);
                        paragraphRepository.save(art3paragraph2);
                        paragraphRepository.save(art3paragraph3);
                        paragraphRepository.save(art4paragraph1);
                        paragraphRepository.save(art4paragraph2);
                        paragraphRepository.save(art4paragraph3);
                        paragraphRepository.save(art4paragraph4);
                        paragraphRepository.save(art5paragraph1);
                        paragraphRepository.save(art5paragraph2);
                        paragraphRepository.save(art5paragraph3);
                        paragraphRepository.save(art6paragraph1);
                        paragraphRepository.save(art6paragraph2);
                        paragraphRepository.save(art6paragraph3);
                        paragraphRepository.save(art6paragraph4);
                        paragraphRepository.save(art7paragraph1);
                        paragraphRepository.save(art7paragraph2);
                        paragraphRepository.save(art7paragraph3);
                        paragraphRepository.save(art8paragraph1);
                        paragraphRepository.save(art8paragraph2);
                        paragraphRepository.save(art8paragraph3);
                        paragraphRepository.save(art9paragraph1);
                        paragraphRepository.save(art9paragraph2);
                        paragraphRepository.save(art9paragraph3);
                        paragraphRepository.save(art9paragraph4);
                        paragraphRepository.save(art9paragraph5);
                        paragraphRepository.save(art17paragraph1);
                        paragraphRepository.save(art17paragraph2);
                        paragraphRepository.save(art17paragraph3);
                        paragraphRepository.save(art17paragraph4);
                        paragraphRepository.save(art17paragraph5);
                        paragraphRepository.save(art18paragraph1);
                        paragraphRepository.save(art18paragraph2);
                        paragraphRepository.save(art18paragraph3);
                        paragraphRepository.save(art18paragraph4);
                        paragraphRepository.save(art19paragraph1);
                        paragraphRepository.save(art19paragraph2);
                        paragraphRepository.save(art19paragraph3);
                        paragraphRepository.save(art19paragraph4);
                        paragraphRepository.save(art19paragraph5);
                        paragraphRepository.save(art20paragraph1);
                        paragraphRepository.save(art20paragraph2);
                        paragraphRepository.save(art20paragraph3);
                        paragraphRepository.save(art20paragraph4);
                        paragraphRepository.save(art20paragraph5);
                        paragraphRepository.save(art21paragraph1);
                        paragraphRepository.save(art21paragraph2);
                        paragraphRepository.save(art21paragraph3);
                        paragraphRepository.save(art21paragraph4);
                        // Paragraph artparagraph = new Paragraph("", '', "",
                        // article1);
                }
        }
}