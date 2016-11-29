-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 29 Novembre 2016 à 15:49
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
(6, 2, 0, 10),
(12, 1, 5, 25),
(12, 8, 1, 40),
(13, 1, 3, 45);

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
(1, 6, 0, 10),
(1, 12, 3, 10),
(1, 13, 2, 10),
(2, 12, 4, 12),
(2, 13, 5, 10);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=22 ;

--
-- Contenu de la table `entretien`
--

INSERT INTO `entretien` (`id`, `id_entreprise`, `id_etudiant`, `id_salle`, `date_debut`, `date_fin`) VALUES
(15, 6, 1, 1, '2016-11-23 08:00:00', '2016-11-23 08:10:00'),
(16, 6, 2, 1, '2016-11-23 08:10:00', '2016-11-23 08:20:00'),
(17, 12, 1, 1, '2016-11-23 08:00:00', '2016-11-23 08:25:00'),
(18, 12, 2, 1, '2016-11-23 08:25:00', '2016-11-23 08:37:00'),
(19, 12, 8, 1, '2016-11-23 08:37:00', '2016-11-23 09:17:00'),
(20, 13, 1, 2, '2016-11-23 08:00:00', '2016-11-23 08:45:00'),
(21, 13, 2, 2, '2016-11-23 08:45:00', '2016-11-23 08:55:00');

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
(1, '2016-11-23 08:00:00', '2016-11-23 18:00:00', '');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `salle`
--

INSERT INTO `salle` (`id`, `libelle`, `capacite`) VALUES
(1, 'Salle 1', 2),
(2, 'Salle 2', 1),
(3, 'testeste', 30),
(4, 'testststst', 4);

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
  `date_debut_dispo` datetime NOT NULL,
  `date_fin_dispo` datetime NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `email`, `telephone`, `id_profil`, `date_debut_dispo`, `date_fin_dispo`, `password`) VALUES
(1, 'CHEMIER2', 'Baptiste', 'bc@gmail.com', NULL, 1, '2016-11-23 00:00:00', '2016-11-23 00:00:00', 'chemierbaptiste'),
(2, 'TEST', 'test', 'testetest', NULL, 3, '2016-11-23 00:00:00', '2016-11-23 00:00:00', 'nguyenaisi'),
(3, 'WILS', 'Aurélien', 'aw@gmail.com', NULL, 1, '2016-11-23 00:00:00', '2016-11-23 00:00:00', 'wilsaurelien'),
(6, 'De Bene', 'Doriane', 'debeneDoriane@gmail.com', NULL, 3, '2016-11-23 00:00:00', '2016-11-23 00:00:00', '123456'),
(7, 'COMBES', 'Joris', 'cj@gmail.com', '0666573372', 1, '2016-11-23 00:00:00', '2016-11-23 00:00:00', '123456'),
(8, 'PENAS', 'Olivier', 'pn@gmail.com', '0666573372', 1, '2016-02-15 00:00:00', '2016-02-16 00:00:00', '123456'),
(9, 'BILLON', 'Guillaume', 'bg@gmail.com', '0666573372', 1, '2016-02-15 00:00:00', '2016-02-16 00:00:00', '123456'),
(10, 'test', 'testprenom', 'test@gmail.com', NULL, 2, '2016-11-23 00:00:00', '2016-11-23 00:00:00', 'testsetstes'),
(11, 'test', 'testprenom', 'test@gmail.com', NULL, 2, '2016-11-23 00:00:00', '2016-11-23 00:00:00', 'testsetstes'),
(12, 'Madame', 'sopra', 'tetete@gmail.com', NULL, 3, '2016-11-23 00:00:00', '2016-11-23 00:00:00', 'tetetetet'),
(13, 'Monsieur', 'CGI', 'tetete@gmail.com', NULL, 3, '2016-11-23 00:00:00', '2016-11-23 00:00:00', 'tetetete');

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
