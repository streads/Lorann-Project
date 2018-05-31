-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Jeu 31 Mai 2018 à 20:08
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `lorann`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllLevel` ()  NO SQL
BEGIN
SELECT name,height,width 
FROM level;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getElement` (IN `map_level` INT)  NO SQL
BEGIN
SELECT identifier, positionX, positionY
FROM contenir
WHERE levelNumber = map_level;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getLevel` (IN `desired_map` INT)  NO SQL
BEGIN
SELECT name,height,width 
FROM level
WHERE number = desired_map;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `contenir`
--

CREATE TABLE `contenir` (
  `id` int(11) NOT NULL,
  `levelNumber` int(11) NOT NULL,
  `identifier` char(5) NOT NULL,
  `positionX` int(11) DEFAULT NULL,
  `positionY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `contenir`
--

INSERT INTO `contenir` (`id`, `levelNumber`, `identifier`, `positionX`, `positionY`) VALUES
(1, 1, 'L', 5, 6),
(2, 2, 'C', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `element`
--

CREATE TABLE `element` (
  `identifier` char(5) NOT NULL,
  `description` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `element`
--

INSERT INTO `element` (`identifier`, `description`) VALUES
('-', 'Horizontal Bone'),
('/', 'Bone'),
('1', 'Monster1'),
('2', 'Monster2'),
('3', 'Monster3'),
('4', 'Monster4'),
('B', 'Crystal Ball'),
('C', 'Closed Door'),
('L', 'Lorann'),
('O', 'Opened Door'),
('P', 'Purse'),
('|', 'Vertical Bone');

-- --------------------------------------------------------

--
-- Structure de la table `level`
--

CREATE TABLE `level` (
  `number` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `height` int(255) DEFAULT NULL,
  `width` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `level`
--

INSERT INTO `level` (`number`, `name`, `height`, `width`) VALUES
(1, 'Exia', 12, 20),
(2, 'Home', 12, 20);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `contenir`
--
ALTER TABLE `contenir`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Level` (`levelNumber`),
  ADD KEY `Identifier` (`identifier`);

--
-- Index pour la table `element`
--
ALTER TABLE `element`
  ADD PRIMARY KEY (`identifier`);

--
-- Index pour la table `level`
--
ALTER TABLE `level`
  ADD PRIMARY KEY (`number`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `contenir`
--
ALTER TABLE `contenir`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `level`
--
ALTER TABLE `level`
  MODIFY `number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `contenir`
--
ALTER TABLE `contenir`
  ADD CONSTRAINT `identifierfk` FOREIGN KEY (`identifier`) REFERENCES `element` (`identifier`),
  ADD CONSTRAINT `levelfk` FOREIGN KEY (`levelNumber`) REFERENCES `map` (`numero`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
