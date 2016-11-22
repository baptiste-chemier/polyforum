-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 22 Novembre 2016 à 14:15
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
  `id_etudiant` int(11) NOT NULL,
  `id_entreprise` int(11) NOT NULL,
  PRIMARY KEY (`id_etudiant`,`id_entreprise`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `choix_entreprise`
--

INSERT INTO `choix_entreprise` (`id_etudiant`, `id_entreprise`) VALUES
(2, 6);

-- --------------------------------------------------------

--
-- Structure de la table `choix_etudiant`
--

CREATE TABLE IF NOT EXISTS `choix_etudiant` (
  `id_entreprise` int(11) NOT NULL,
  `id_etudiant` int(11) NOT NULL,
  PRIMARY KEY (`id_entreprise`,`id_etudiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `choix_etudiant`
--

INSERT INTO `choix_etudiant` (`id_entreprise`, `id_etudiant`) VALUES
(6, 1);

-- --------------------------------------------------------

--
-- Structure de la table `configuration`
--

CREATE TABLE IF NOT EXISTS `configuration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_forum` date NOT NULL,
  `date_debut_forum` date NOT NULL,
  `date_fin_forum` date NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `entretien`
--

CREATE TABLE IF NOT EXISTS `entretien` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_entreprise` int(11) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `id_salle` int(11) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `fichier`
--

CREATE TABLE IF NOT EXISTS `fichier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `salle`
--

INSERT INTO `salle` (`id`, `libelle`, `capacite`) VALUES
(1, 'Salle 1', 3),
(2, 'Salle 2', 4);

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
  `date_debut_dispo` datetime DEFAULT NULL,
  `date_fin_dispo` datetime DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `email`, `telephone`, `id_profil`, `date_debut_dispo`, `date_fin_dispo`, `password`) VALUES
(1, 'CHEMIER2', 'Baptiste', 'bc@gmail.com', NULL, 1, '2016-11-22 00:00:00', '2016-11-22 00:00:00', 'chemierbaptiste'),
(2, 'NGUYEN', 'AiSi', 'an@gmail.com', NULL, 1, NULL, NULL, 'nguyenaisi'),
(3, 'WILS', 'Aurélien', 'aw@gmail.com', NULL, 1, NULL, NULL, 'wilsaurelien'),
(5, 'FOURNIER', 'Elodie', 'fe@gmail.com', NULL, 1, NULL, NULL, 'fournierelodie'),
(6, 'De Bene', 'Doriane', 'debeneDoriane@gmail.com', NULL, 3, NULL, NULL, '123456'),
(7, 'COMBES', 'Joris', 'cj@gmail.com', '0666573372', 1, '2016-02-15 00:00:00', '2016-02-16 00:00:00', '123456'),
(8, 'PENAS', 'Olivier', 'pn@gmail.com', '0666573372', 1, '2016-02-15 00:00:00', '2016-02-16 00:00:00', '123456'),
(9, 'BILLON', 'Guillaume', 'bg@gmail.com', '0666573372', 1, '2016-02-15 00:00:00', '2016-02-16 00:00:00', '123456');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
