package com.templateproject.api.controller;

import com.templateproject.api.entity.*;
import com.templateproject.api.repository.*;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author harle
 */
public class MainController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ArticleRepository articleRepository;
    
    @GetMapping("/restoreall_database")
    public String restoreAll() {
        
        // remove all categories, authors and articles
        authorRepository.deleteAll();
        categoryRepository.deleteAll();
        articleRepository.deleteAll();
        
        // create the restoration category
        Category restoration = categoryRepository.save(new Category("Restoration"));

        // add categories to the restorearticle category
        categoryRepository.save(new Category("Fun","fun", restoration));
        categoryRepository.save(new Category("Sport", "sport", restoration));
        categoryRepository.save(new Category("Carie","carie", restoration));
        categoryRepository.save(new Category("Miam","miam", restoration));
        categoryRepository.save(new Category("Ça coute bonbon", "ca-coute-bonbon", restoration));
        
        
// create the restoreauthor authors
        Author restoreauthor = authorRepository.save(new Author("Restoration"));
           
        // add authors to the restoreauthor author
        authorRepository.save(new Author("Florian","Helaine", restoreauthor));
        authorRepository.save(new Author("Patrick","Harlé", restoreauthor));
        authorRepository.save(new Author("Guillaume","Gros", restoreauthor));
        authorRepository.save(new Author("Selin","Agzibuyuk", restoreauthor));
        authorRepository.save(new Author("Alexandre","Boutemy", restoreauthor));
     
           // create the restorearticle articles
        Article restorearticle = articleRepository.save(new Article("Restoration"));
        
        // add articles to the restorearticle article
        //n°1
        articleRepository.save(new Article(
               4,1,
                "Le caramel qui colle aux dents : pour ou contre ?",
                "le-caramel-qui-colle-aux-dents-pour-ou-contre",
                "<section><h2>Introduction</h2><p>Le caramel, ce délice sucré et collant, est un incontournable pour de nombreux amateurs de sucreries. Cependant, il suscite également un débat animé : faut-il l'apprécier sans retenue ou le mettre de côté pour éviter les désagréments qu'il peut causer ? À travers un sondage réalisé auprès d'un groupe de personnes, nous avons recueilli différentes opinions. Dans cet article, nous explorerons les arguments en faveur et contre le caramel collant pour vous aider à vous forger votre propre opinion.</p><h2>Les partisans du caramel collant</h2><p>Suite au sondage effectué auprès des membres de la Wild Code School, à ce jour, six d'entre eux ont exprimé leur amour pour le caramel collant. Huit ont, au contraire, fait part de leur aversion profonde pour cette sucrecie. Concernant les six personnes pour, voici les raisons qui peuvent expliquer ce choix :</p><ol><li>Plaisir gustatif : Selon ces fervents défenseurs, le caramel collant procure une expérience gustative unique. Sa texture douce et fondante associée à sa saveur sucrée procure une sensation de satisfaction intense.</li><li>Tradition : Le caramel fait partie de la culture culinaire depuis des générations. Pour certains, le caramel collant est un symbole d'authenticité et de nostalgie, rappelant des souvenirs d'enfance et de moments conviviaux.</li><li>Variété de desserts : Le caramel collant est un ingrédient clé dans de nombreux desserts appréciés dans le monde entier. Tarte au caramel, crème caramel, flan, bonbons au caramel... Ces gourmandises ne seraient pas les mêmes sans la texture collante et délicieuse du caramel.</li></ol><h2>Les opposants au caramel collant</h2><p>Concernant les huit personnes contre, les arguments peuvent se baser principalement sur les inconvénients suivants :</p><ol><li>Problèmes dentaires : Le caramel collant peut se loger entre les dents et provoquer des caries. Il est souvent difficile à éliminer complètement, même avec un brossage minutieux. Les opposants soulignent l'importance de prendre soin de sa santé bucco-dentaire en évitant les aliments collants.</li><li>Risque d'étouffement : Le caramel collant peut poser un risque d'étouffement, en particulier pour les jeunes enfants ou les personnes âgées. Sa consistance visqueuse peut obstruer les voies respiratoires si une petite quantité est avalée de travers.</li><li>Prise de poids : Le caramel est riche en sucre et en calories. Une consommation excessive de caramel collant peut contribuer à une prise de poids non désirée et à des problèmes de santé associés.</li></ol><h2>Conclusion</h2><p>Le débat autour du caramel collant reste donc ouvert, avec des arguments solides émanant des deux côtés. Finalement, la décision de consommer du caramel collant repose sur un équilibre entre le plaisir gustatif qu'il procure et les éventuels inconvénients pour la santé. Il est important de se rappeler que la modération est la clé dans la dégustation de tout aliment sucré. Alors, que vous soyez pour ou contre le caramel collant, l'essentiel est de savourer vos sucreries préférées avec modération et de prendre soin de votre santé bucco-dentaire.</p></section>",
                "Un sondage a été réalisé auprès de membres de la Wild Code School pour savoir s'ils aimaient le caramel qui colle aux dents. Des résultats surprenants, ou pas...",
                true,
                LocalDateTime.parse("2023-06-15 15:14:00"),
                LocalDateTime.parse("2023-06-15 15:14:00"),
                "https://media.istockphoto.com/id/516358950/fr/photo/partie-de-sucre-blanc.jpg?s=612x612&w=0&k=20&c=PQdHZX3hIDHlQQHHoHJNAGxyQun5ORH_4kXJteRYyUU=",
        restorearticle));
        //n°2
        articleRepository.save(new Article(
                3,2,
                "La Maison du Diabète et des maladies chroniques - Marcq-en-Baroeul",
                "la-maison-du-diabète-et-des-maladies-chroniques-marcq-en-baroeul",
                "<section><h2>La Maison du Diabète</h2><p>Renforcement des liens entre employeurs et salariés, obligations légales, enjeu de certification, lutte contre l’absentéisme …La prévention et la promotion de la santé en entreprise sont un enjeu de croissance durable.Nous mettons à disposition nos compétences et notre expertise en éducation et promotion de la santé afin de rendre accessibles les démarches de prévention santé en entreprise.A l’écoute du grand public, nous avons pour objectif de compléter la démarche éducative et préventive des structures sociales (centres sociaux, associations sportives, associations de parents …), en s’appuyant sur diverses activités.Nous avons la volonté d’aller à la rencontre de la population, en sillonnant chaque route des Hauts-de-France, grâce à son Bus Santé notamment.</p></section>",
                "La santé et le bien-être de vos collaborateurs sont primordiaux pour le bon fonctionnement de votre entreprise.",
                false,
                LocalDateTime.parse("2023-06-18 14:00:00"),
                LocalDateTime.parse("2023-06-18 14:00:00"),
                "https://www.maison-diabete.com/wordpress/wp-content/uploads/slide_prestas.jpg",
        restorearticle));
        //n°3
        articleRepository.save(new Article(
                 3,2,
                "Le Bus Santé sillonne les routes de la Région Hauts-de-France",
                "le-bus-santé-sillonne-les-routes-de-la-région-hauts-de-france",
                "<section><h2>Le Bus Santé sillonne nos routes </h2><p>Les Conseiller-es Prévention Santé (infirmière, diététiciennes, professeurs d’activité physique adaptée et sophrologue) sont à votre écoute au sein du Bus Santé. Ils vous proposent un accompagnement, des conseils adaptés sur différentes thématiques (alimentation, activité physique, bien-être, sommeil), une orientation/ relais vers des structures locales… , et des dépistages du diabète (glycémie capillaire), de la maladie rénale chronique (test urinaire) et des maladies cardio-vasculaires (prise de tension artérielle) Le Bus Santé intervient en partenariat avec les collectivités, les entreprises,…  sur la Région Hauts-de-France.</p></section>",
                "Sensibiliser le grand public, et plus particulièrement les personnes en situation précaire et/ou ayant un accès aux soins plus difficile.",
                false,
                LocalDateTime.parse("2023-06-19 11:56:54"),
                LocalDateTime.parse("2023-06-19 11:56:54"),
                "https://www.maison-diabete.com/wordpress/wp-content/uploads/slide_bus.jpg",
        restorearticle));
        //n°4
        articleRepository.save(new Article(
                 3,2,
                "La prévention en actions !",
                "la-prévention-en-actions!",
                "<section><h2>Maison du diabète : la prévention en actions !</h2><p>Composée de professionnels formés aux actions de prévention et d’éducation (conseillères en prévention santé de formation infirmière et diététicienne ainsi que des professeurs d’Activité Physique Adaptée), l’équipe de la Maison du diabète et des maladies chroniques assure les missions suivantes :accueil individuel et information,séances de dépistage,actions de prévention des maladies chroniques et de leurs complications,actions de sensibilisation aux comportements favorables à la santé,ateliers thématiques collectifs (alimentation, facteurs de risques, hygiène de vie…),séances de relaxation/automassage et d’activité physique,formation et information des professionnels de santé.Afin de compléter sa démarche éducative, la Maison du diabète et des maladies chroniques oriente les usagers et s’appuie sur les activités et le savoir-faire des structures locales : centres sociaux, associations sportives, association de patients, réseaux de santé existants…</p></section>",
                "Des entretiens individuels avec une conseillère en prévention santé (de formation infirmière et diététicienne) et des ateliers collectifs",
                false,
                LocalDateTime.parse("2023-06-20 14:40:55"),
                LocalDateTime.parse("2023-06-20 14:40:55"),
                "https://www.maison-diabete.com/wordpress/wp-content/uploads/l%C3%A9gumes-642x428.jpg",
        restorearticle));
        //n°5
        articleRepository.save(new Article(
                 4,2,
                "Salade de harengs aux lentilles",
                "salade-de-harengs-aux-lentilles",
                "<section><h2>Salade de harengs aux lentilles</h2><p>Faire cuire les lentilles dans une grande quantité d’eau pendant 20 à 25 min environ.Démarrer la cuisson à l’eau froide et saler à mi-cuisson. Égoutter les lentilles lorsqu’elles sont cuites.Éplucher les échalotes, les couper finement. Dans un bol, mélanger l’huile, le vinaigre, le miel et les échalotes. Saler, poivrer.Verser la sauce sur les lentilles. Mélanger.Mettre les lentilles dans un plat. Déposer les filets de hareng égouttés au-dessus.Parsemer de persil ciselé.Cette salade peut être préparée également avec du haddock mais le coût sera plus élevé.</p></section>",
                "Un petit plat sympa et facile à préparer pour 4 personnes ! Succulent !",
                false,
                LocalDateTime.parse("2023-06-17 12:09:20"),
                LocalDateTime.parse("2023-06-17 12:09:20"),
                "https://www.mangerbouger.fr/manger-mieux/la-fabrique-a-menus/_next/image?url=https%3A%2F%2Fapi-prod-fam.mangerbouger.fr%2Fstorage%2Frecettes_generiques%2Fplatcomplet.png&w=1920&q=75",
        restorearticle));
        //n°6
        articleRepository.save(new Article(
                 2,2,
                "Une idée de sport : le Badminton",
                "une-idée-de-sport-le-badminton",
                "<section><h2>Le Badminton</h2><p>Sport de raquette, le badminton oppose 2 joueurs ou deux équipes de 2 joueurs séparés par un filet et se joue généralement en salle. Le but est de frapper un volant de manière à le faire tomber dans le demi-terrain adverse, ou d’obliger ses adversaires à commettre une faute.Ce sport d’endurance fait travailler les muscles et particulièrement ceux des jambes, des fessiers et des bras.Il améliore la coordination et l’équilibre, par sa grande variété de mouvements.Il vous faut une raquette, un volant et des chaussures adaptées : souples et légères, avec une semelle en gomme. Ajoutez-y un tee-shirt assorti d’un short (les femmes peuvent opter pour une jupe ou une robe).Il n’est pas indispensable d’être dans un club pour pratiquer le badminton, vous pouvez tout à fait vous achetez des raquettes et jouer dans votre jardin, sur la page…Le badminton est le sport de raquette le plus rapide du monde : le volant peut en effet atteindre une vitesse de 300 km/h lors d’un smash. Le record actuel en compétition s’élève à la vitesse impressionnante de 332 km/h.</p></section>",
                "Objectif : Gagner deux sets en marquant, pour chacun, 21 points avant son adversaire avec 2 points d'écarts au minimum !",
                false,
                LocalDateTime.parse("2023-06-11 12:12:55"),
                LocalDateTime.parse("2023-06-11 12:12:55"),
                "https://www.mangerbouger.fr/var/mb/storage/images/_aliases/reference/2/6/3/6/6362-1-eng-GB/activite_physique_badminton.jpg",
        restorearticle));
        //n°7
        articleRepository.save(new Article(
                 4,2,
                "Bien manger sans se ruiner",
                "bien-manger-sans-se-ruiner",
                "<section><h2>Bien manger sans se ruiner !</h2><p>Les légumes secs ne sont pas si longs à préparer. Par exemple, les lentilles et les pois cassés n’ont pas besoin de trempage. Les haricots secs, les pois chiches et les fèves nécessitent de tremper au moins 12h avant cuisson, mais si vous n’avez pas le temps, vous pouvez les trouver précuits en bocaux ou en conserves, prêts à réchauffer ou encore surgelés.Un dahl de lentilles, un chili sin carne avec des haricots rouges ou encore des beignets de pois chiches… Il y en a pour tous les goûts, et tout ça sans se ruiner !riz complet, pâtes et semoule complètes… Vous aimez ? Tant mieux, car ils sont beaucoup plus riches en fibres que les produits raffinés et sont également bon marché. Par exemple préférez le pain complet au pain blanc.  Il est recommandé de manger des féculents complets au moins une fois par jour.Pâtes complètes courgettes pesto, curry de pois chiches et riz complet, semoule au lait à la fleur d’oranger…Profitons aussi des produits de saison souvent moins chers. Les prix peuvent varier d’une année sur l’autre en fonction des récoltes mais les fruits et légumes de saison ont souvent le meilleur rapport qualité-prix. En plus cela évite qu’ils ne poussent sous des serres chauffées et peuvent être cultivés sous nos latitudes, c’est meilleur pour la planète.Le bio permet de manger des produits sans trace de pesticides. Certes ils sont souvent plus chers. Mais en mangeant moins de viande, moins de produits transformés et plus d’aliments de saison, votre porte-monnaie s’y retrouve!</p></section>",
                "Petites astuces bonnes pour tous, pour l’environnement et pour le porte-monnaie.",
                false,
                LocalDateTime.parse("2023-06-10 12:16:21"),
                LocalDateTime.parse("2023-06-10 12:16:21"),
                "https://www.mangerbouger.fr/var/mb/storage/images/_aliases/reference/2/6/3/6/6362-1-eng-GB/activite_physique_badminton.jpg",
        restorearticle));
        //n°8
        articleRepository.save(new Article(
                
                 1,2,
                "Sucre est aussi le nom d'une ville !",
                "sucre-est-aussi-le-nom-d'une-ville",
                "<section><h2>Sucre est aussi le nom d'une ville !</h2><p>Sucre (prononcé /ˈsu.kɾe/) est la capitale constitutionnelle de la Bolivie. Elle est également la capitale du département de Chuquisaca et le chef-lieu de la province d'Oropeza. Sa population s'élève à 259 388 habitants lors du recensement bolivien de 2012.</p></section>",
                "Le sucre côté géographie.",
                false,
                LocalDateTime.parse("2023-06-09 12:19:46"),
                LocalDateTime.parse("2023-06-09 12:19:46"),
                "https://commons.wikimedia.org/wiki/File:Sucre,_Bolivia_-_(24545082440).jpg?uselang=fr",
        restorearticle));

        
        return "/";
     }
}