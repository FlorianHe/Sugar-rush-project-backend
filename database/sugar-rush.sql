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
  `is_main` bit(1) NOT NULL,
  `category_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `modification_date` datetime(6) DEFAULT NULL,
  `publication_date` datetime(6) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `leads` varchar(255) DEFAULT NULL,
  `publication_image` varchar(255) DEFAULT NULL,
  `slug` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKy5kkohbk00g0w88fi05k2hcw` (`category_id`),
  CONSTRAINT `FKy5kkohbk00g0w88fi05k2hcw` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table sugar-rush.article : ~10 rows (environ)
INSERT INTO `article` (`is_main`, `category_id`, `id`, `modification_date`, `publication_date`, `author`, `leads`, `publication_image`, `slug`, `title`) VALUES
	(b'1', 4, 1, '2023-06-15 15:14:00.000000', '2023-06-15 15:14:00.000000', 'Selin', 'Un sondage a été réalisé auprès de membres de la Wild Code School pour savoir s\'ils aimaient le caramel qui colle aux dents. Des résultats surprenants, ou pas...', 'https://media.istockphoto.com/id/516358950/fr/photo/partie-de-sucre-blanc.jpg?s=612x612&w=0&k=20&c=PQdHZX3hIDHlQQHHoHJNAGxyQun5ORH_4kXJteRYyUU=', 'le-caramel-qui-colle-aux-dents-pour-ou-contre', 'Le caramel qui colle aux dents : pour ou contre ?'),
	(b'0', 3, 2, '2023-06-18 14:00:00.000000', '2023-06-18 14:00:00.000000', 'Patrick', 'La santé et le bien-être de vos collaborateurs sont primordiaux pour le bon fonctionnement de votre entreprise.', 'https://www.maison-diabete.com/wordpress/wp-content/uploads/slide_prestas.jpg', 'la-maison-du-diabète-et-des-maladies-chroniques-marcq-en-baroeul', 'La Maison du Diabète et des maladies chroniques - Marcq-en-Baroeul'),
	(b'0', 3, 3, '2023-06-19 11:56:54.000000', '2023-06-19 11:56:54.000000', 'Patrick', 'Sensibiliser le grand public, et plus particulièrement les personnes en situation précaire et/ou ayant un accès aux soins plus difficile.', 'https://www.maison-diabete.com/wordpress/wp-content/uploads/slide_bus.jpg', 'le-bus-santé-sillonne-les-routes-de-la-région-hauts-de-france', 'Le Bus Santé sillonne les routes de la Région Hauts-de-France'),
	(b'0', 3, 4, '2023-06-20 14:40:55.000000', '2023-06-20 14:40:55.000000', 'Patrick', 'Des entretiens individuels avec une conseillère en prévention santé (de formation infirmière et diététicienne) et des ateliers collectifs', 'https://www.maison-diabete.com/wordpress/wp-content/uploads/l%C3%A9gumes-642x428.jpg', 'la-prévention-en-actions!', 'La prévention en actions !'),
	(b'0', 4, 5, '2023-06-17 12:09:20.000000', '2023-06-17 12:09:20.000000', 'Patrick', 'Un petit plat sympa et facile à préparer pour 4 personnes ! Succulent !', 'https://www.mangerbouger.fr/manger-mieux/la-fabrique-a-menus/_next/image?url=https%3A%2F%2Fapi-prod-fam.mangerbouger.fr%2Fstorage%2Frecettes_generiques%2Fplatcomplet.png&w=1920&q=75', 'salade-de-harengs-aux-lentilles', 'Salade de harengs aux lentilles'),
	(b'0', 2, 6, '2023-06-11 12:12:55.000000', '2023-06-11 12:12:55.000000', 'Patrick', 'Objectif : Gagner deux sets en marquant, pour chacun, 21 points avant son adversaire avec 2 points d\'écarts au minimum !', 'https://www.mangerbouger.fr/var/mb/storage/images/_aliases/reference/2/6/3/6/6362-1-eng-GB/activite_physique_badminton.jpg', 'une-idée-de-sport-le-badminton', 'Une idée de sport : le Badminton'),
	(b'0', 4, 7, '2023-06-10 12:16:21.000000', '2023-06-10 12:16:21.000000', 'Patrick', 'Petites astuces bonnes pour tous, pour l’environnement et pour le porte-monnaie.', 'https://img.freepik.com/photos-gratuite/gros-plan-sac-reutilisable-epicerie-herbe_23-2148523381.jpg?w=826&t=st=1689761312~exp=1689761912~hmac=30140aa1f44fd4bdd546694cb23c6748ed2ca3ed2974b34afeae9d3bfd296fab', 'bien-manger-sans-se-ruiner', 'Bien manger sans se ruiner'),
	(b'0', 1, 8, '2023-06-09 12:19:46.000000', '2023-06-09 12:19:46.000000', 'Patrick', 'Le sucre côté géographie.', 'https://commons.wikimedia.org/wiki/File:Sucre,_Bolivia_-_(24545082440).jpg?uselang=fr', 'sucre-est-aussi-le-nom-d\'une-ville', 'Sucre est aussi le nom d\'une ville !'),
	(b'1', 4, 9, '2023-07-07 08:58:25.008000', '2023-07-07 08:58:25.008000', 'string', 'Plongez dans l\'univers impitoyable de Candy Crush Saga, où seuls les plus vaillants pourront triompher des niveaux les plus redoutables. Entre stratégie et persévérance, découvrez les défis qui mettent les nerfs des joueurs à rude épreuve.', 'http://json.helaine.eu/CandyCrush.jpg', 'candy-crush-saga-defis-plus-ardus-qui-resistent-joueurs-plus-temeraires', 'Candy Crush Saga : Les défis les plus ardus qui résistent aux joueurs les plus téméraires'),
	(b'1', 4, 10, '2023-06-15 15:14:00.000000', '2023-06-15 15:14:00.000000', 'Patrick', 'La recette du caramel maison', 'https://media.istockphoto.com/id/516358950/fr/photo/partie-de-sucre-blanc.jpg?s=612x612&w=0&k=20&c=PQdHZX3hIDHlQQHHoHJNAGxyQun5ORH_4kXJteRYyUU=', 'recette-caramel-maison-à-la-casserole', 'La recette du caramel maison à la casserole');

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
  `id` bigint NOT NULL AUTO_INCREMENT,
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

-- Listage de la structure de la table sugar-rush. comment
CREATE TABLE IF NOT EXISTS `comment` (
  `article_id` bigint DEFAULT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5yx0uphgjc6ik6hb82kkw501y` (`article_id`),
  CONSTRAINT `FK5yx0uphgjc6ik6hb82kkw501y` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table sugar-rush.comment : ~0 rows (environ)

-- Listage de la structure de la table sugar-rush. paragraph
CREATE TABLE IF NOT EXISTS `paragraph` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` text,
  `title` varchar(255) DEFAULT NULL,
  `type_content` char(1) NOT NULL,
  `article_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpkqkcgary69yaal0ylw0u7w6h` (`article_id`),
  CONSTRAINT `FKpkqkcgary69yaal0ylw0u7w6h` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table sugar-rush.paragraph : ~36 rows (environ)
INSERT INTO `paragraph` (`id`, `content`, `title`, `type_content`, `article_id`) VALUES
	(1, 'La recette classique pour faire son caramel à la casserole à la maison.', 'Pour un caramel toujours réussi', 'I', 10),
	(2, '100 g de sucre de préférence en morceaux\r\n2 cuillerées à soupe d\'eau (30 ml)\r\nQuelques gouttes de vinaigre blanc à passer sur la casserole avant de commencer', 'Ingredients', 'P', 10),
	(3, '1-Passer un peu de vinaigre blanc sur le fond et les parois de la casserole\r\n2-Mettre sucre et eau dans une casserole correspondant à la taille du feu et dissoudre le sucre dans l\'eau délicatement sans en mettre sur les bords\r\n3-Faire bouillir. Ensuite ne plus remuer à la spatule, ni bouger la casserole.\r\nQuand la coloration apparaît, remuer légèrement la casserole pour répartir la coloration\r\n4-Attention à bien surveiller la coloration : trop claire ça ne fait que sucrer; trop foncée c\'est âcre donc immangeable !', 'Préparation', 'P', 10),
	(4, 'Faire son caramel est facile mais il faut prendre des précautions pour que tout se passe bien :\r\n\r\n- Toujours utiliser du sucre blanc. A choisir, préférer le sucre en morceaux au sucre en poudre qui contiendrait moins d\'impuretés.\r\nLe matériel doit être très propre. C\'est pourquoi on peut passer un peu vinaigre blanc sur les parois tout ceci afin d\'éviter toute impureté qui pourrait faire cristalliser le sucre.\r\n\r\n- Au préalable bien dissoudre le sucre avec l\'eau sans en mettre sur les parois de la casserole.\r\n\r\n- Pendant la cuisson du sucre, il est très important de ne pas y toucher : surtout ne pas mélanger à la spatule, ni remuer la casserole avant le début de la coloration, ni ajouter d\'eau froide: Ne rien faire sauf surveiller !\r\n\r\nLa cuisson va vite et il ne faut pas quitter son caramel des yeux ', 'Trucs & astuces', 'P', 10),
	(5, 'La poser dans l\'évier, attendre un début de refroidissement puis mettre de l\'eau; ça fond tout seul.', 'Nettoyage', 'P', 10),
	(6, 'Chemiser = répartir le caramel dans le moule. Attention opération délicate, faire très attention car le caramel est brûlant.\r\nDès l\'apparition de la belle couleur blonde, verser le caramel dans le moule à chemiser en l\'inclinant pour napper les bords sans se brûler !!!\r\nIl faut travailler assez vite car le sucre dans la casserole se solidifie vite !', 'Moulage', 'P', 10),
	(7, 'Le caramel liquide sert à parfumer une préparation.\r\nDès l\'apparition de la belle couleur blonde, hors du feu, \r\najouter avec beaucoup de précautions 1/2 verre d\'eau : \r\nATTENTION ! éloigner ses yeux, ses mains car les projections sont brûlantes !!! \r\nUne partie se re- solidifie et il faut le remettre sur feu doux pour le faire fondre. \r\nQuand tout est bien fondu, verser le caramel dans un flacon de verre et fermer.', 'Caramel liquide', 'P', 10),
	(8, 'Cela peut rendre service car si le moule le permet, \r\non fait le caramel directement dedans : \r\nmélanger le sucre et l\'eau directement dans un plat adéquat mais \r\npas en plastique cependant, ça chauffe ! \r\nensuite 4 à 5 mn environ pour 900 w: \r\nATTENTION, cela dépend de la puissance des appareils donc y \r\naller progressivement dans le temps en surveillant bien la coloration !', 'Utilisation du micro-ondes', 'P', 10),
	(9, 'Envoyez nous SVP vos commentaires et retours d\'expérience... ', 'Partagez votre expérience !', 'C', 10),
	(10, 'Le caramel, ce délice sucré et collant, est un incontournable pour de nombreux amateurs de sucreries. \r\nCependant, il suscite également un débat animé : faut-il l\'apprécier sans retenue ou le mettre de côté pour éviter les désagréments qu\'il peut causer ? \r\nÀ travers un sondage réalisé auprès d\'un groupe de personnes, nous avons recueilli différentes opinions. \r\nDans cet article, nous explorerons les arguments en faveur et contre le caramel collant pour vous aider à vous forger votre propre opinion.', 'Le caramel qui colle aux dents...', 'I', 1),
	(11, 'Suite au sondage effectué auprès des membres de la Wild Code School, à ce jour, six d\'entre eux ont exprimé leur amour pour le caramel collant. \r\nHuit ont, au contraire, fait part de leur aversion profonde pour cette sucrecie. \r\nConcernant les six personnes pour, voici les raisons qui peuvent expliquer ce choix :\r\nPlaisir gustatif : Selon ces fervents défenseurs, le caramel collant procure une expérience gustative unique. \r\nSa texture douce et fondante associée à sa saveur sucrée procure une sensation de satisfaction intense.\r\nTradition : Le caramel fait partie de la culture culinaire depuis des générations. Pour certains, le caramel collant est un symbole d\'authenticité et de nostalgie, \r\nrappelant des souvenirs d\'enfance et de moments conviviaux.\r\nVariété de desserts : Le caramel collant est un ingrédient clé dans de nombreux desserts appréciés dans le monde entier. \r\nTarte au caramel, crème caramel, flan, bonbons au caramel... Ces gourmandises ne seraient pas les mêmes sans la texture collante et délicieuse du caramel.\r\n', 'Les partisans du caramel collant', 'P', 1),
	(12, 'Concernant les huit personnes contre, les arguments peuvent se baser principalement sur les inconvénients suivants :\r\nProblèmes dentaires : Le caramel collant peut se loger entre les dents et provoquer des caries. \r\nIl est souvent difficile à éliminer complètement, même avec un brossage minutieux. \r\nLes opposants soulignent l\'importance de prendre soin de sa santé bucco-dentaire en évitant les aliments collants.\r\nRisque d\'étouffement : Le caramel collant peut poser un risque d\'étouffement, en particulier pour les jeunes enfants ou les personnes âgées. \r\nSa consistance visqueuse peut obstruer les voies respiratoires si une petite quantité est avalée de travers.\r\nPrise de poids : Le caramel est riche en sucre et en calories. Une consommation excessive de caramel collant peut contribuer à une prise de poids non désirée \r\net à des problèmes de santé associés.\r\n', 'Les opposants au caramel collant', 'P', 1),
	(13, 'Le débat autour du caramel collant reste donc ouvert, avec des arguments solides émanant des deux côtés. \r\nFinalement, la décision de consommer du caramel collant repose sur un équilibre entre le plaisir gustatif qu\'il procure et les éventuels inconvénients pour la santé. \r\nIl est important de se rappeler que la modération est la clé dans la dégustation de tout aliment sucré. \r\nAlors, que vous soyez pour ou contre le caramel collant, l\'essentiel est de savourer vos sucreries préférées avec modération et de prendre soin de votre santé bucco-dentaire.', 'Le débat reste ouvert...', 'C', 1),
	(14, 'Renforcement des liens entre employeurs et salariés, obligations légales, enjeu de certification, lutte contre l’absentéisme …\r\nLa prévention et la promotion de la santé en entreprise sont un enjeu de croissance durable.', 'La Maison du Diabète', 'I', 2),
	(15, 'Nous mettons à disposition nos compétences et notre expertise en éducation et promotion de la santé afin de rendre accessibles les démarches de prévention santé en entreprise.\r\nA l’écoute du grand public, nous avons pour objectif de compléter la démarche éducative et préventive des structures sociales (centres sociaux, associations sportives, associations de parents …), en s’appuyant sur diverses activités.\r\nNous avons la volonté d’aller à la rencontre de la population, en sillonnant chaque route des Hauts-de-France, grâce à son Bus Santé notamment.', 'Compétences et expertise', 'P', 2),
	(16, 'Passez nous rendre visite ...', 'Une maison à votre service', 'C', 2),
	(17, 'Les Conseiller-es Prévention Santé (infirmière, diététiciennes, professeurs d’activité physique adaptée et sophrologue) sont à votre écoute au sein du Bus Santé', 'Le Bus Santé sillonne nos routes ', 'I', 3),
	(18, 'Ils vous proposent un accompagnement, des conseils adaptés sur différentes thématiques (alimentation, activité physique, bien-être, sommeil), \r\nune orientation / relais vers des structures locales… , et des dépistages du diabète (glycémie capillaire), de la maladie rénale chronique (test urinaire) \r\net des maladies cardio-vasculaires (prise de tension artérielle).', 'Pour un dépistage proactif ', 'P', 3),
	(19, 'Le Bus Santé intervient en partenariat avec les collectivités, les entreprises,…  sur la Région Hauts-de-France.', 'Un véritable partenariat', 'C', 3),
	(20, 'Pour une approche pluri-disciplinaire ! ', 'Maison du diabète : la prévention en actions !', 'I', 4),
	(21, 'Composée de professionnels formés aux actions de prévention et d’éducation \r\n(conseillères en prévention santé de formation infirmière et diététicienne ainsi que des professeurs d’Activité Physique Adaptée), \r\nl’équipe de la Maison du diabète et des maladies chroniques assure les missions suivantes :\r\naccueil individuel et information,\r\nséances de dépistage,\r\nactions de prévention des maladies chroniques et de leurs complications,\r\nactions de sensibilisation aux comportements favorables à la santé.\r\n', 'Une équipe de choc', 'P', 4),
	(22, 'Ateliers thématiques collectifs (alimentation, facteurs de risques, hygiène de vie…),\r\nséances de relaxation/automassage et d’activité physique,\r\nformation et information des professionnels de santé.\r\nAfin de compléter sa démarche éducative, la Maison du diabète et des maladies chroniques oriente les usagers \r\net s’appuie sur les activités et le savoir-faire des structures locales : \r\ncentres sociaux, associations sportives, association de patients, réseaux de santé existants…', 'Des ateliers pratiques', 'P', 4),
	(23, 'Consultez notre documentation et prenez de bonnes habitudes au service d\'une bonne hygiène de vie !', 'Nos brochures d\'information', 'C', 4),
	(24, 'Simple, nutritionnel et goûteux...un petit plat qui vous surprendra !', 'Salade de harengs aux lentilles', 'I', 5),
	(25, 'Faire cuire les lentilles dans une grande quantité d’eau pendant 20 à 25 min environ.Démarrer la cuisson à l’eau froide et saler à mi-cuisson. \r\nÉgoutter les lentilles lorsqu’elles sont cuites.Éplucher les échalotes, les couper finement. \r\nDans un bol, mélanger l’huile, le vinaigre, le miel et les échalotes. \r\nSaler, poivrer.Verser la sauce sur les lentilles. \r\nMélanger.Mettre les lentilles dans un plat. \r\nDéposer les filets de hareng égouttés au-dessus.Parsemer de persil ciselé.', 'Préparation', 'P', 5),
	(26, 'Cette salade peut être préparée également avec du haddock mais le coût sera plus élevé.\r\nBon appétit !', 'Une variante', 'C', 5),
	(27, 'Sport de raquette, le badminton oppose 2 joueurs ou deux équipes de 2 joueurs séparés par un filet et se joue généralement en salle.', 'Quid ?', 'I', 6),
	(28, 'Le but est de frapper un volant de manière à le faire tomber dans le demi-terrain adverse, ou d’obliger ses adversaires à commettre une faute.\r\nCe sport d’endurance fait travailler les muscles et particulièrement ceux des jambes, des fessiers et des bras.\r\nIl améliore la coordination et l’équilibre, par sa grande variété de mouvements.', 'Objectifs et règles', 'P', 6),
	(29, 'Il vous faut une raquette, un volant et des chaussures adaptées : souples et légères, avec une semelle en gomme. \r\nAjoutez-y un tee-shirt assorti d’un short (les femmes peuvent opter pour une jupe ou une robe).\r\nIl n’est pas indispensable d’être dans un club pour pratiquer le badminton, vous pouvez tout à fait vous achetez des raquettes et jouer dans votre jardin, sur la page…\r\n', 'Equipement', 'P', 6),
	(30, 'Le badminton est le sport de raquette le plus rapide du monde : le volant peut en effet atteindre une vitesse de 300 km/h lors d’un smash. \r\nLe record actuel en compétition s’élève à la vitesse impressionnante de 332 km/h.', 'Le saviez-vous ?', 'C', 6),
	(31, 'Les légumes secs ne sont pas si longs à préparer...', 'Bien manger sans se ruiner !', 'I', 7),
	(32, 'Par exemple, les lentilles et les pois cassés n’ont pas besoin de trempage. \r\nLes haricots secs, les pois chiches et les fèves nécessitent de tremper au moins 12h avant cuisson, \r\nmais si vous n’avez pas le temps, vous pouvez les trouver précuits en bocaux ou en conserves, prêts à réchauffer ou encore surgelés.\r\nUn dahl de lentilles, un chili sin carne avec des haricots rouges ou encore des beignets de pois chiches… Il y en a pour tous les goûts, et tout ça sans se ruiner !\r\nRiz complet, pâtes et semoule complètes… Vous aimez ? Tant mieux, car ils sont beaucoup plus riches en fibres que les produits raffinés et sont également bon marché. \r\nPar exemple préférez le pain complet au pain blanc.  Il est recommandé de manger des féculents complets au moins une fois par jour.\r\nPâtes complètes courgettes pesto, curry de pois chiches et riz complet, semoule au lait à la fleur d’oranger…\r\nProfitons aussi des produits de saison souvent moins chers. Les prix peuvent varier d’une année sur l’autre en fonction des récoltes \r\nmais les fruits et légumes de saison ont souvent le meilleur rapport qualité-prix. \r\nEn plus cela évite qu’ils ne poussent sous des serres chauffées et peuvent être cultivés sous nos latitudes, \r\nc’est meilleur pour la planète.\r\n', 'Quelques conseils', 'P', 7),
	(33, 'Le bio permet de manger des produits sans trace de pesticides. \r\nMais en mangeant moins de viande, moins de produits transformés et plus d’aliments de saison, votre porte-monnaie s’y retrouve!', 'Certes ils sont souvent plus chers', 'C', 7),
	(34, 'Sucre,  c\'est aussi le nom d\'une ville !', 'Un point du globe ', 'I', 8),
	(35, 'Sucre (prononcé su.kɾe) est la capitale constitutionnelle de la Bolivie. \r\nElle est également la capitale du département de Chuquisaca et le chef-lieu de la province d\'Oropeza. \r\n', 'Escapade en Bolivie', 'P', 8),
	(36, 'Sa population s\'élève à 259 388 habitants lors du recensement bolivien de 2012.', 'Démographie', 'C', 8);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
