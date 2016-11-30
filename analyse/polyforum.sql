-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 30 Novembre 2016 à 16:48
-- Version du serveur :  5.6.16
-- Version de PHP :  5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `polyforum`
--

-- --------------------------------------------------------

--
-- Structure de la table `choix_entreprise`
--

CREATE TABLE IF NOT EXISTS `choix_entreprise` (
  `id_entreprise` int(11) NOT NULL,
  `id_etudiant` int(11) NOT NULL,
  `ordre` int(11) NOT NULL,
  `duree` int(11) NOT NULL,
  PRIMARY KEY (`id_entreprise`,`id_etudiant`),
  KEY `id_etudiant` (`id_etudiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `choix_entreprise`
--

INSERT INTO `choix_entreprise` (`id_entreprise`, `id_etudiant`, `ordre`, `duree`) VALUES
(17, 48, 4, 40),
(17, 50, 1, 40),
(17, 51, 7, 40),
(17, 53, 8, 40),
(17, 54, 3, 40),
(17, 56, 5, 40),
(17, 57, 2, 40),
(17, 61, 6, 40),
(18, 48, 4, 40),
(18, 51, 2, 40),
(18, 60, 3, 40),
(18, 63, 1, 40),
(19, 46, 1, 40),
(19, 55, 2, 40),
(20, 49, 4, 40),
(20, 57, 1, 40),
(20, 62, 2, 40),
(20, 63, 3, 40),
(21, 49, 1, 40),
(21, 54, 10, 40),
(21, 55, 7, 40),
(21, 56, 9, 40),
(21, 58, 2, 40),
(21, 59, 6, 40),
(21, 63, 8, 40),
(22, 50, 8, 40),
(22, 51, 10, 40),
(22, 52, 1, 40),
(22, 54, 9, 40),
(22, 57, 2, 40),
(23, 41, 4, 40),
(23, 49, 9, 40),
(23, 51, 10, 40),
(23, 55, 3, 40),
(23, 56, 2, 40),
(23, 58, 1, 40),
(23, 59, 8, 40),
(24, 50, 9, 40),
(24, 51, 8, 40),
(24, 53, 10, 40),
(24, 60, 1, 40),
(25, 55, 10, 40),
(25, 57, 2, 40),
(25, 60, 1, 40),
(26, 48, 10, 40),
(26, 54, 5, 40),
(26, 56, 1, 40);

-- --------------------------------------------------------

--
-- Structure de la table `choix_etudiant`
--

CREATE TABLE IF NOT EXISTS `choix_etudiant` (
  `id_etudiant` int(11) NOT NULL,
  `id_entreprise` int(11) NOT NULL,
  `ordre` int(11) NOT NULL,
  `duree` int(11) NOT NULL,
  PRIMARY KEY (`id_etudiant`,`id_entreprise`),
  KEY `id_entreprise` (`id_entreprise`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `choix_etudiant`
--

INSERT INTO `choix_etudiant` (`id_etudiant`, `id_entreprise`, `ordre`, `duree`) VALUES
(48, 17, 1, 40),
(48, 21, 5, 40),
(48, 23, 4, 40),
(49, 17, 2, 40),
(49, 22, 1, 40),
(50, 23, 5, 40),
(51, 21, 2, 40),
(51, 23, 1, 40),
(51, 25, 5, 40),
(52, 17, 3, 40),
(52, 18, 1, 40),
(52, 20, 2, 40),
(53, 19, 3, 40),
(53, 23, 4, 40),
(53, 24, 5, 40),
(54, 20, 3, 40),
(54, 23, 5, 40),
(54, 25, 2, 40),
(54, 26, 1, 40),
(55, 18, 2, 40),
(55, 21, 5, 40),
(55, 26, 1, 40),
(56, 17, 1, 40),
(56, 22, 2, 40),
(56, 25, 5, 40),
(57, 17, 5, 40),
(57, 27, 1, 40),
(58, 18, 2, 40),
(58, 20, 1, 40),
(58, 23, 5, 40),
(58, 25, 4, 40),
(59, 18, 5, 40),
(59, 21, 2, 40),
(59, 23, 1, 40),
(60, 18, 3, 40),
(60, 19, 1, 40),
(60, 21, 5, 40),
(60, 24, 2, 40),
(61, 22, 4, 40),
(61, 23, 1, 40),
(61, 26, 5, 40),
(62, 17, 1, 40),
(62, 21, 5, 40),
(62, 22, 4, 40),
(63, 25, 1, 40);

-- --------------------------------------------------------

--
-- Structure de la table `entretien`
--

CREATE TABLE IF NOT EXISTS `entretien` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_entreprise` int(11) NOT NULL,
  `id_etudiant` int(11) NOT NULL,
  `id_salle` int(11) NOT NULL,
  `date_debut` datetime NOT NULL,
  `date_fin` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1571 ;

--
-- Contenu de la table `entretien`
--

INSERT INTO `entretien` (`id`, `id_entreprise`, `id_etudiant`, `id_salle`, `date_debut`, `date_fin`) VALUES
(1521, 17, 53, 5, '2016-11-23 14:00:00', '2016-11-23 14:40:00'),
(1522, 17, 57, 5, '2016-11-23 14:40:00', '2016-11-23 15:20:00'),
(1523, 17, 51, 5, '2016-11-23 15:20:00', '2016-11-23 16:00:00'),
(1524, 17, 61, 5, '2016-11-23 16:00:00', '2016-11-23 16:40:00'),
(1525, 17, 56, 5, '2016-11-23 16:40:00', '2016-11-23 17:20:00'),
(1526, 17, 48, 5, '2016-11-23 17:20:00', '2016-11-23 18:00:00'),
(1527, 18, 59, 5, '2016-11-23 14:00:00', '2016-11-23 14:40:00'),
(1528, 18, 48, 5, '2016-11-23 14:40:00', '2016-11-23 15:20:00'),
(1529, 18, 60, 5, '2016-11-23 15:20:00', '2016-11-23 16:00:00'),
(1530, 18, 55, 5, '2016-11-23 16:00:00', '2016-11-23 16:40:00'),
(1531, 18, 51, 5, '2016-11-23 16:40:00', '2016-11-23 17:20:00'),
(1532, 18, 58, 5, '2016-11-23 17:20:00', '2016-11-23 18:00:00'),
(1533, 19, 53, 5, '2016-11-23 14:00:00', '2016-11-23 14:40:00'),
(1534, 19, 55, 5, '2016-11-23 14:40:00', '2016-11-23 15:20:00'),
(1535, 19, 60, 5, '2016-11-23 15:20:00', '2016-11-23 16:00:00'),
(1536, 19, 46, 5, '2016-11-23 16:00:00', '2016-11-23 16:40:00'),
(1537, 20, 49, 6, '2016-11-23 14:00:00', '2016-11-23 14:40:00'),
(1538, 20, 63, 6, '2016-11-23 14:40:00', '2016-11-23 15:20:00'),
(1539, 20, 54, 6, '2016-11-23 15:20:00', '2016-11-23 16:00:00'),
(1540, 20, 62, 6, '2016-11-23 16:00:00', '2016-11-23 16:40:00'),
(1541, 20, 52, 6, '2016-11-23 16:40:00', '2016-11-23 17:20:00'),
(1542, 20, 57, 6, '2016-11-23 17:20:00', '2016-11-23 18:00:00'),
(1543, 21, 55, 6, '2016-11-23 14:00:00', '2016-11-23 14:40:00'),
(1544, 21, 54, 6, '2016-11-23 14:40:00', '2016-11-23 15:20:00'),
(1545, 21, 56, 6, '2016-11-23 15:20:00', '2016-11-23 16:00:00'),
(1546, 21, 59, 6, '2016-11-23 16:00:00', '2016-11-23 16:40:00'),
(1547, 21, 63, 6, '2016-11-23 16:40:00', '2016-11-23 17:20:00'),
(1548, 21, 48, 6, '2016-11-23 17:20:00', '2016-11-23 18:00:00'),
(1549, 22, 51, 6, '2016-11-23 14:00:00', '2016-11-23 14:40:00'),
(1550, 22, 54, 6, '2016-11-23 14:40:00', '2016-11-23 15:20:00'),
(1551, 22, 50, 6, '2016-11-23 15:20:00', '2016-11-23 16:00:00'),
(1552, 22, 62, 6, '2016-11-23 16:00:00', '2016-11-23 16:40:00'),
(1553, 22, 61, 6, '2016-11-23 16:40:00', '2016-11-23 17:20:00'),
(1554, 22, 56, 6, '2016-11-23 17:20:00', '2016-11-23 18:00:00'),
(1555, 23, 51, 7, '2016-11-23 14:00:00', '2016-11-23 14:40:00'),
(1556, 23, 49, 7, '2016-11-23 14:40:00', '2016-11-23 15:20:00'),
(1557, 23, 59, 7, '2016-11-23 15:20:00', '2016-11-23 16:00:00'),
(1558, 23, 58, 7, '2016-11-23 16:00:00', '2016-11-23 16:40:00'),
(1559, 23, 50, 7, '2016-11-23 16:40:00', '2016-11-23 17:20:00'),
(1560, 23, 54, 7, '2016-11-23 17:20:00', '2016-11-23 18:00:00'),
(1561, 24, 53, 8, '2016-11-23 14:00:00', '2016-11-23 14:40:00'),
(1562, 24, 50, 8, '2016-11-23 14:40:00', '2016-11-23 15:20:00'),
(1563, 24, 51, 8, '2016-11-23 15:20:00', '2016-11-23 16:00:00'),
(1564, 24, 60, 8, '2016-11-23 16:00:00', '2016-11-23 16:40:00'),
(1565, 25, 55, 8, '2016-11-23 14:00:00', '2016-11-23 14:40:00'),
(1566, 25, 56, 8, '2016-11-23 14:40:00', '2016-11-23 15:20:00'),
(1567, 25, 51, 8, '2016-11-23 15:20:00', '2016-11-23 16:00:00'),
(1568, 25, 58, 8, '2016-11-23 16:00:00', '2016-11-23 16:40:00'),
(1569, 25, 57, 8, '2016-11-23 16:40:00', '2016-11-23 17:20:00'),
(1570, 25, 54, 8, '2016-11-23 17:20:00', '2016-11-23 18:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `fichier`
--

CREATE TABLE IF NOT EXISTS `fichier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filepath` varchar(255) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `forum`
--

CREATE TABLE IF NOT EXISTS `forum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_debut_forum` datetime NOT NULL,
  `date_fin_forum` datetime NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `forum`
--

INSERT INTO `forum` (`id`, `date_debut_forum`, `date_fin_forum`, `email`) VALUES
(1, '2016-11-23 14:00:00', '2016-11-23 18:00:00', '');

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE IF NOT EXISTS `profil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `profil`
--

INSERT INTO `profil` (`id`, `libelle`) VALUES
(1, 'Etudiant'),
(2, 'Enseignant'),
(3, 'Entreprise');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE IF NOT EXISTS `salle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  `capacite` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `salle`
--

INSERT INTO `salle` (`id`, `libelle`, `capacite`) VALUES
(5, 'Salle 19', 3),
(6, 'Salle 20', 3),
(7, 'Salle 16', 1),
(8, 'Salle 18', 2);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telephone` varchar(10) DEFAULT NULL,
  `id_profil` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=70 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `email`, `telephone`, `id_profil`, `password`) VALUES
(14, 'BULL', '', 'BULL@testmail.com', '0438369470', 3, 'BULL'),
(15, 'NAXOS', '', 'NAXOS@testmail.com', '0487492575', 3, 'NAXO'),
(16, 'SCULPTEO', '', 'SCULPTEO@testmail.com', '0653046320', 3, 'SCUL'),
(17, 'SOGETI HIGH TECH', '', 'SOGETI_HIGH_TECH@testmail.com', '0481165289', 3, 'SOGE'),
(18, 'SYNCHROTEAM', '', 'SYNCHROTEAM@testmail.com', '0442290783', 3, 'SYNC'),
(19, 'ABSYS CYBORG', '', 'ABSYS_CYBORG@testmail.com', '0484898238', 3, 'ABSY'),
(20, 'CALLISTEO', '', 'CALLISTEO@testmail.com', '0483790344', 3, 'CALL'),
(21, 'CONIX', '', 'CONIX@testmail.com', '0661530242', 3, 'CONI'),
(22, 'LUXIDE', '', 'LUXIDE@testmail.com', '0494773351', 3, 'LUXI'),
(23, 'MICROSOFT ', '', 'MICROSOFT@testmail.com', '0698724987', 3, 'MICR'),
(24, 'NAVIDIS', '', 'NAVIDIS@testmail.com', '0656959856', 3, 'NAVI'),
(25, 'SAVSOFT', '', 'SAVSOFT@testmail.com', '0615518588', 3, 'SAVS'),
(26, 'SYBASE FRANCE', '', 'SYBASE_FRANCE@testmail.com', '0634640031', 3, 'SYBA'),
(27, 'AUSY', '', 'AUSY@testmail.com', '0467994743', 3, 'AUSY'),
(28, 'BEEMO TECHNOLOGIE', '', 'BEEMO_TECHNOLOGIE@testmail.com', '0460225080', 3, 'BEEM'),
(29, 'FASTCONNECT', '', 'FASTCONNECT@testmail.com', '0422945853', 3, 'FAST'),
(30, 'NOVISYS', '', 'NOVISYS@testmail.com', '0460449463', 3, 'NOVI'),
(31, 'SAGERE', '', 'SAGERE@testmail.com', '0673381030', 3, 'SAGE'),
(32, 'AGIT GROUPE', '', 'AGIT_GROUPE@testmail.com', '0432888722', 3, 'AGIT'),
(33, 'GENAPI', '', 'GENAPI@testmail.com', '0427008206', 3, 'GENA'),
(34, 'GROUPE STERIA', '', 'GROUPE_STERIA@testmail.com', '0412515396', 3, 'GROU'),
(35, 'IT ORIGIN', '', 'IT_ORIGIN@testmail.com', '0493110683', 3, 'IT_O'),
(36, 'SISOFT', '', 'SISOFT@testmail.com', '0617389175', 3, 'SISO'),
(37, 'AB CONSEIL', '', 'AB_CONSEIL@testmail.com', '0424475611', 3, 'AB_C'),
(38, 'ALGORIA', '', 'ALGORIA@testmail.com', '0649910193', 3, 'ALGO'),
(39, 'BLUE CARAVEL', '', 'BLUE_CARAVEL@testmail.com', '0472742756', 3, 'BLUE'),
(40, 'INTEMPORA', '', 'INTEMPORA@testmail.com', '0680658968', 3, 'INTE'),
(41, 'LOGAXONE', '', 'LOGAXONE@testmail.com', '0638048392', 3, 'LOGA'),
(42, 'SOGETI', '', 'SOGETI@testmail.com', '0470480526', 3, 'SOGE'),
(43, 'SOGIX', '', 'SOGIX@testmail.com', '0440653162', 3, 'SOGI'),
(44, 'MARTIN', 'JULIE', 'MARTIN_JULIE@testmail.com', '0481100587', 1, 'JMARTIN'),
(45, 'BERNARD', 'AXEL', 'BERNARD_AXEL@testmail.com', '0633727629', 1, 'ABERNARD'),
(46, 'ROUX', 'ENZO', 'ROUX_ENZO@testmail.com', '0642512367', 1, 'EROUX'),
(47, 'THOMAS', 'EVAN', 'THOMAS_EVAN@testmail.com', '0628703095', 1, 'ETHOMAS'),
(48, 'PETIT', 'HUGO', 'PETIT_HUGO@testmail.com', '0688541440', 1, 'HPETIT'),
(49, 'DURAND', 'JADE', 'DURAND_JADE@testmail.com', '0635386802', 1, 'JDURAND'),
(50, 'MICHEL', 'JULES', 'MICHEL_JULES@testmail.com', '0670295537', 1, 'JMICHEL'),
(51, 'ROBERT', 'LÉO', 'ROBERT_LÉO@testmail.com', '0447075128', 1, 'LROBERT'),
(52, 'RICHARD', 'LOUIS', 'RICHARD_LOUIS@testmail.com', '0471906570', 1, 'LRICHARD'),
(53, 'SIMON', 'ZOE', 'SIMON_ZOE@testmail.com', '0616787109', 1, 'ZSIMON'),
(54, 'MOREAU', 'LOUKA', 'MOREAU_LOUKA@testmail.com', '0622871048', 1, 'LMOREAU'),
(55, 'DUBOIS', 'LUCAS', 'DUBOIS_LUCAS@testmail.com', '0477697931', 1, 'LDUBOIS'),
(56, 'BLANC', 'MAËL', 'BLANC_MAËL@testmail.com', '0431119626', 1, 'MBLANC'),
(57, 'LAURENT', 'MALO', 'LAURENT_MALO@testmail.com', '0649567246', 1, 'MLAURENT'),
(58, 'GIRARD', 'MANON', 'GIRARD_MANON@testmail.com', '0414286837', 1, 'MGIRARD'),
(59, 'BERTRAND', 'NOAH', 'BERTRAND_NOAH@testmail.com', '0684953411', 1, 'NBERTRAND'),
(60, 'GARNIER', 'NOLAN', 'GARNIER_NOLAN@testmail.com', '0679563435', 1, 'NGARNIER'),
(61, 'DAVID', 'PAUL', 'DAVID_PAUL@testmail.com', '0698527830', 1, 'PDAVID'),
(62, 'MOREL', 'ROBIN', 'MOREL_ROBIN@testmail.com', '0423486853', 1, 'RMOREL'),
(63, 'GUERIN', 'LENA', 'GUERIN_LENA@testmail.com', '0673998921', 1, 'LGUERIN'),
(64, 'ROY', 'SACHA', 'ROY_SACHA@testmail.com', '0662759688', 1, 'SROY'),
(65, 'ROUSSEAU', 'SIMON', 'ROUSSEAU_SIMON@testmail.com', '0484841429', 1, 'SROUSSEAU'),
(66, 'ANDRE', 'THÉO', 'ANDRE_THÉO@testmail.com', '0626423865', 1, 'TANDRE'),
(67, 'GAUTIER', 'LUC', 'GAUTIER_LUC@testmail.com', '0416878665', 1, 'LGAUTIER'),
(68, 'BONNET', 'LEA', 'BONNET_LEA@testmail.com', '0452511713', 1, 'LBONNET'),
(69, 'LAMBERT', 'TIAGO', 'LAMBERT_TIAGO@testmail.com', '0435505555', 1, 'TLAMBERT');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `choix_entreprise`
--
ALTER TABLE `choix_entreprise`
  ADD CONSTRAINT `choix_entreprise_ibfk_2` FOREIGN KEY (`id_etudiant`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `choix_entreprise_ibfk_1` FOREIGN KEY (`id_entreprise`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `choix_etudiant`
--
ALTER TABLE `choix_etudiant`
  ADD CONSTRAINT `choix_etudiant_ibfk_2` FOREIGN KEY (`id_entreprise`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `choix_etudiant_ibfk_1` FOREIGN KEY (`id_etudiant`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
