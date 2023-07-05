-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           8.0.33 - MySQL Community Server - GPL
-- SE du serveur:                Win64
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Listage de la structure de la base pour sugar-rush
CREATE DATABASE IF NOT EXISTS `sugar-rush` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sugar-rush`;

-- Listage de la structure de la table sugar-rush. article
CREATE TABLE IF NOT EXISTS `article` (
  `id` int NOT NULL AUTO_INCREMENT,
  `author_id` int NOT NULL,
  `category_id` int NOT NULL,
  `leads` varchar(255) DEFAULT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `is_main` bit(1) NOT NULL,
  `modification_date` datetime(6) DEFAULT NULL,
  `publication_date` datetime(6) DEFAULT NULL,
  `publication_image` varchar(255) DEFAULT NULL,
  `slug` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `auth` int NOT NULL,
  `categ` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK92kabsgi6rs0pmr2866m7q7m9` (`author_id`),
  KEY `FKy5kkohbk00g0w88fi05k2hcw` (`category_id`),
  CONSTRAINT `FK92kabsgi6rs0pmr2866m7q7m9` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  CONSTRAINT `FKy5kkohbk00g0w88fi05k2hcw` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table sugar-rush.article : ~8 rows (environ)
INSERT INTO `article` (`id`, `author_id`, `category_id`, `leads`, `content`, `is_main`, `modification_date`, `publication_date`, `publication_image`, `slug`, `title`, `auth`, `categ`) VALUES
	(1, 1, 4, 'Un sondage a été réalisé auprès de membres de la Wild Code School pour savoir s\'ils aimaient le caramel qui colle aux dents. Des résultats surprenants, ou pas...', '<section><h2>Introduction</h2><p>Le caramel, ce délice sucré et collant, est un incontournable pour de nombreux amateurs de sucreries. Cependant, il suscite également un débat animé : faut-il l\'apprécier sans retenue ou le mettre de côté pour éviter les désagréments qu\'il peut causer ? À travers un sondage réalisé auprès d\'un groupe de personnes, nous avons recueilli différentes opinions. Dans cet article, nous explorerons les arguments en faveur et contre le caramel collant pour vous aider à vous forger votre propre opinion.</p><h2>Les partisans du caramel collant</h2><p>Suite au sondage effectué auprès des membres de la Wild Code School, à ce jour, six d\'entre eux ont exprimé leur amour pour le caramel collant. Huit ont, au contraire, fait part de leur aversion profonde pour cette sucrecie. Concernant les six personnes pour, voici les raisons qui peuvent expliquer ce choix :</p><ol><li>Plaisir gustatif : Selon ces fervents défenseurs, le caramel collant procure une expérience gustative unique. Sa texture douce et fondante associée à sa saveur sucrée procure une sensation de satisfaction intense.</li><li>Tradition : Le caramel fait partie de la culture culinaire depuis des générations. Pour certains, le caramel collant est un symbole d\'authenticité et de nostalgie, rappelant des souvenirs d\'enfance et de moments conviviaux.</li><li>Variété de desserts : Le caramel collant est un ingrédient clé dans de nombreux desserts appréciés dans le monde entier. Tarte au caramel, crème caramel, flan, bonbons au caramel... Ces gourmandises ne seraient pas les mêmes sans la texture collante et délicieuse du caramel.</li></ol><h2>Les opposants au caramel collant</h2><p>Concernant les huit personnes contre, les arguments peuvent se baser principalement sur les inconvénients suivants :</p><ol><li>Problèmes dentaires : Le caramel collant peut se loger entre les dents et provoquer des caries. Il est souvent difficile à éliminer complètement, même avec un brossage minutieux. Les opposants soulignent l\'importance de prendre soin de sa santé bucco-dentaire en évitant les aliments collants.</li><li>Risque d\'étouffement : Le caramel collant peut poser un risque d\'étouffement, en particulier pour les jeunes enfants ou les personnes âgées. Sa consistance visqueuse peut obstruer les voies respiratoires si une petite quantité est avalée de travers.</li><li>Prise de poids : Le caramel est riche en sucre et en calories. Une consommation excessive de caramel collant peut contribuer à une prise de poids non désirée et à des problèmes de santé associés.</li></ol><h2>Conclusion</h2><p>Le débat autour du caramel collant reste donc ouvert, avec des arguments solides émanant des deux côtés. Finalement, la décision de consommer du caramel collant repose sur un équilibre entre le plaisir gustatif qu\'il procure et les éventuels inconvénients pour la santé. Il est important de se rappeler que la modération est la clé dans la dégustation de tout aliment sucré. Alors, que vous soyez pour ou contre le caramel collant, l\'essentiel est de savourer vos sucreries préférées avec modération et de prendre soin de votre santé bucco-dentaire.</p></section>', b'1', '2023-06-15 15:14:00.000000', '2023-06-15 15:14:00.000000', 'https://media.istockphoto.com/id/516358950/fr/photo/partie-de-sucre-blanc.jpg?s=612x612&w=0&k=20&c=PQdHZX3hIDHlQQHHoHJNAGxyQun5ORH_4kXJteRYyUU=', 'le-caramel-qui-colle-aux-dents-pour-ou-contre', 'Le caramel qui colle aux dents : pour ou contre ?', 0, 0),
	(2, 2, 3, 'La santé et le bien-être de vos collaborateurs sont primordiaux pour le bon fonctionnement de votre entreprise.', '<section><h2>La Maison du Diabète</h2><p>Renforcement des liens entre employeurs et salariés, obligations légales, enjeu de certification, lutte contre l’absentéisme …La prévention et la promotion de la santé en entreprise sont un enjeu de croissance durable.Nous mettons à disposition nos compétences et notre expertise en éducation et promotion de la santé afin de rendre accessibles les démarches de prévention santé en entreprise.A l’écoute du grand public, nous avons pour objectif de compléter la démarche éducative et préventive des structures sociales (centres sociaux, associations sportives, associations de parents …), en s’appuyant sur diverses activités.Nous avons la volonté d’aller à la rencontre de la population, en sillonnant chaque route des Hauts-de-France, grâce à son Bus Santé notamment.</p></section>', b'0', '2023-06-18 14:00:00.000000', '2023-06-18 14:00:00.000000', 'https://www.maison-diabete.com/wordpress/wp-content/uploads/slide_prestas.jpg', 'la-maison-du-diabète-et-des-maladies-chroniques-marcq-en-baroeul', 'La Maison du Diabète et des maladies chroniques - Marcq-en-Baroeul', 0, 0),
	(3, 2, 3, 'Sensibiliser le grand public, et plus particulièrement les personnes en situation précaire et/ou ayant un accès aux soins plus difficile.', '<section><h2>Le Bus Santé sillonne nos routes </h2><p>Les Conseiller-es Prévention Santé (infirmière, diététiciennes, professeurs d’activité physique adaptée et sophrologue) sont à votre écoute au sein du Bus Santé. Ils vous proposent un accompagnement, des conseils adaptés sur différentes thématiques (alimentation, activité physique, bien-être, sommeil), une orientation/ relais vers des structures locales… , et des dépistages du diabète (glycémie capillaire), de la maladie rénale chronique (test urinaire) et des maladies cardio-vasculaires (prise de tension artérielle) Le Bus Santé intervient en partenariat avec les collectivités, les entreprises,…  sur la Région Hauts-de-France.</p></section>', b'0', '2023-06-19 11:56:54.000000', '2023-06-19 11:56:54.000000', 'https://www.maison-diabete.com/wordpress/wp-content/uploads/slide_bus.jpg', 'le-bus-santé-sillonne-les-routes-de-la-région-hauts-de-france', 'Le Bus Santé sillonne les routes de la Région Hauts-de-France', 0, 0),
	(4, 2, 3, 'Des entretiens individuels avec une conseillère en prévention santé (de formation infirmière et diététicienne) et des ateliers collectifs', '<section><h2>Maison du diabète : la prévention en actions !</h2><p>Composée de professionnels formés aux actions de prévention et d’éducation (conseillères en prévention santé de formation infirmière et diététicienne ainsi que des professeurs d’Activité Physique Adaptée), l’équipe de la Maison du diabète et des maladies chroniques assure les missions suivantes :accueil individuel et information,séances de dépistage,actions de prévention des maladies chroniques et de leurs complications,actions de sensibilisation aux comportements favorables à la santé,ateliers thématiques collectifs (alimentation, facteurs de risques, hygiène de vie…),séances de relaxation/automassage et d’activité physique,formation et information des professionnels de santé.Afin de compléter sa démarche éducative, la Maison du diabète et des maladies chroniques oriente les usagers et s’appuie sur les activités et le savoir-faire des structures locales : centres sociaux, associations sportives, association de patients, réseaux de santé existants…</p></section>', b'0', '2023-06-20 14:40:55.000000', '2023-06-20 14:40:55.000000', 'https://www.maison-diabete.com/wordpress/wp-content/uploads/l%C3%A9gumes-642x428.jpg', 'la-prévention-en-actions!', 'La prévention en actions !', 0, 0),
	(5, 2, 4, 'Un petit plat sympa et facile à préparer pour 4 personnes ! Succulent !', '<section><h2>Salade de harengs aux lentilles</h2><p>Faire cuire les lentilles dans une grande quantité d’eau pendant 20 à 25 min environ.Démarrer la cuisson à l’eau froide et saler à mi-cuisson. Égoutter les lentilles lorsqu’elles sont cuites.Éplucher les échalotes, les couper finement. Dans un bol, mélanger l’huile, le vinaigre, le miel et les échalotes. Saler, poivrer.Verser la sauce sur les lentilles. Mélanger.Mettre les lentilles dans un plat. Déposer les filets de hareng égouttés au-dessus.Parsemer de persil ciselé.Cette salade peut être préparée également avec du haddock mais le coût sera plus élevé.</p></section>', b'0', '2023-06-17 12:09:20.000000', '2023-06-17 12:09:20.000000', 'https://www.mangerbouger.fr/manger-mieux/la-fabrique-a-menus/_next/image?url=https%3A%2F%2Fapi-prod-fam.mangerbouger.fr%2Fstorage%2Frecettes_generiques%2Fplatcomplet.png&w=1920&q=75', 'salade-de-harengs-aux-lentilles', 'Salade de harengs aux lentilles', 0, 0),
	(6, 2, 2, 'Objectif : Gagner deux sets en marquant, pour chacun, 21 points avant son adversaire avec 2 points d\'écarts au minimum !', '<section><h2>Le Badminton</h2><p>Sport de raquette, le badminton oppose 2 joueurs ou deux équipes de 2 joueurs séparés par un filet et se joue généralement en salle. Le but est de frapper un volant de manière à le faire tomber dans le demi-terrain adverse, ou d’obliger ses adversaires à commettre une faute.Ce sport d’endurance fait travailler les muscles et particulièrement ceux des jambes, des fessiers et des bras.Il améliore la coordination et l’équilibre, par sa grande variété de mouvements.Il vous faut une raquette, un volant et des chaussures adaptées : souples et légères, avec une semelle en gomme. Ajoutez-y un tee-shirt assorti d’un short (les femmes peuvent opter pour une jupe ou une robe).Il n’est pas indispensable d’être dans un club pour pratiquer le badminton, vous pouvez tout à fait vous achetez des raquettes et jouer dans votre jardin, sur la page…Le badminton est le sport de raquette le plus rapide du monde : le volant peut en effet atteindre une vitesse de 300 km/h lors d’un smash. Le record actuel en compétition s’élève à la vitesse impressionnante de 332 km/h.</p></section>', b'0', '2023-06-11 12:12:55.000000', '2023-06-11 12:12:55.000000', 'https://www.mangerbouger.fr/var/mb/storage/images/_aliases/reference/2/6/3/6/6362-1-eng-GB/activite_physique_badminton.jpg', 'une-idée-de-sport-le-badminton', 'Une idée de sport : le Badminton', 0, 0),
	(7, 2, 4, 'Petites astuces bonnes pour tous, pour l’environnement et pour le porte-monnaie.', '<section><h2>Bien manger sans se ruiner !</h2><p>Les légumes secs ne sont pas si longs à préparer. Par exemple, les lentilles et les pois cassés n’ont pas besoin de trempage. Les haricots secs, les pois chiches et les fèves nécessitent de tremper au moins 12h avant cuisson, mais si vous n’avez pas le temps, vous pouvez les trouver précuits en bocaux ou en conserves, prêts à réchauffer ou encore surgelés.Un dahl de lentilles, un chili sin carne avec des haricots rouges ou encore des beignets de pois chiches… Il y en a pour tous les goûts, et tout ça sans se ruiner !riz complet, pâtes et semoule complètes… Vous aimez ? Tant mieux, car ils sont beaucoup plus riches en fibres que les produits raffinés et sont également bon marché. Par exemple préférez le pain complet au pain blanc.  Il est recommandé de manger des féculents complets au moins une fois par jour.Pâtes complètes courgettes pesto, curry de pois chiches et riz complet, semoule au lait à la fleur d’oranger…Profitons aussi des produits de saison souvent moins chers. Les prix peuvent varier d’une année sur l’autre en fonction des récoltes mais les fruits et légumes de saison ont souvent le meilleur rapport qualité-prix. En plus cela évite qu’ils ne poussent sous des serres chauffées et peuvent être cultivés sous nos latitudes, c’est meilleur pour la planète.Le bio permet de manger des produits sans trace de pesticides. Certes ils sont souvent plus chers. Mais en mangeant moins de viande, moins de produits transformés et plus d’aliments de saison, votre porte-monnaie s’y retrouve!</p></section>', b'0', '2023-06-10 12:16:21.000000', '2023-06-10 12:16:21.000000', 'https://www.mangerbouger.fr/var/mb/storage/images/_aliases/reference/2/6/3/6/6362-1-eng-GB/activite_physique_badminton.jpg', 'bien-manger-sans-se-ruiner', 'Bien manger sans se ruiner', 0, 0),
	(8, 2, 1, 'Le sucre côté géographie.', '<section><h2>Sucre est aussi le nom d\'une ville !</h2><p>Sucre (prononcé /ˈsu.kɾe/) est la capitale constitutionnelle de la Bolivie. Elle est également la capitale du département de Chuquisaca et le chef-lieu de la province d\'Oropeza. Sa population s\'élève à 259 388 habitants lors du recensement bolivien de 2012.</p></section>', b'0', '2023-06-09 12:19:46.000000', '2023-06-09 12:19:46.000000', 'https://commons.wikimedia.org/wiki/File:Sucre,_Bolivia_-_(24545082440).jpg?uselang=fr', 'sucre-est-aussi-le-nom-d\'une-ville', 'Sucre est aussi le nom d\'une ville !', 0, 0);

-- Listage de la structure de la table sugar-rush. author
CREATE TABLE IF NOT EXISTS `author` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table sugar-rush.author : ~5 rows (environ)
INSERT INTO `author` (`id`, `firstname`, `lastname`) VALUES
	(1, 'Florian', 'Helaine'),
	(2, 'Patrick', 'Harlé'),
	(3, 'Guillaume', 'Gros'),
	(4, 'Selin', 'Agzibuyuk'),
	(5, 'Alexandre', 'Boutemy');

-- Listage de la structure de la table sugar-rush. category
CREATE TABLE IF NOT EXISTS `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `slug` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table sugar-rush.category : ~5 rows (environ)
INSERT INTO `category` (`id`, `name`, `slug`) VALUES
	(1, 'Fun', 'fun'),
	(2, 'Sport', 'sport'),
	(3, 'Carie', 'carie'),
	(4, 'Miam', 'miam'),
	(5, 'Ça coute bonbon', 'ca-coute-bonbon');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
