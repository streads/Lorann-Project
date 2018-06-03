-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Ven 01 Juin 2018 à 14:25
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
WHERE levelnumber = map_level;
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
  `levelnumber` int(11) NOT NULL,
  `identifier` char(5) NOT NULL,
  `positionX` int(11) DEFAULT NULL,
  `positionY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `contenir`
--

INSERT INTO `contenir` (`id`, `levelnumber`, `identifier`, `positionX`, `positionY`) VALUES
(1, 1, 'L', 5, 6),
(2, 1, '/', 5, 10),
(3, 1, '|', 6, 1),
(4, 2, '/', 0, 0),
(5, 2, '-', 1, 0),
(6, 2, '-', 2, 0),
(7, 2, '-', 3, 0),
(8, 2, '-', 4, 0),
(9, 2, '-', 5, 0),
(10, 2, '-', 6, 0),
(11, 2, '-', 7, 0),
(12, 2, '-', 8, 0),
(13, 2, '-', 9, 0),
(14, 2, '-', 10, 0),
(15, 2, '-', 11, 0),
(16, 2, '-', 12, 0),
(17, 2, '/', 13, 0),
(18, 2, '-', 14, 0),
(19, 2, '-', 15, 0),
(20, 2, '-', 16, 0),
(21, 2, '-', 17, 0),
(22, 2, '-', 18, 0),
(23, 2, '/', 19, 0),
(24, 2, '|', 0, 1),
(25, 2, '|', 13, 1),
(26, 2, '3', 18, 1),
(27, 2, '|', 19, 1),
(28, 2, 'C', 0, 2),
(29, 2, 'L', 2, 2),
(30, 2, '|', 13, 2),
(31, 2, '|', 19, 2),
(32, 2, '|', 0, 3),
(33, 2, '|', 19, 3),
(34, 2, '|', 0, 4),
(35, 2, '|', 13, 4),
(36, 2, 'P', 18, 4),
(37, 2, '|', 19, 4),
(38, 2, '/', 0, 5),
(39, 2, '-', 1, 5),
(40, 2, '-', 2, 5),
(41, 2, '-', 3, 5),
(42, 2, '-', 4, 5),
(43, 2, '/', 5, 5),
(44, 2, '-', 6, 5),
(45, 2, '-', 7, 5),
(46, 2, '-', 8, 5),
(47, 2, '-', 11, 5),
(48, 2, '-', 12, 5),
(49, 2, '/', 13, 5),
(50, 2, '-', 14, 5),
(51, 2, '-', 15, 5),
(52, 2, '-', 16, 5),
(53, 2, '-', 17, 5),
(54, 2, '-', 18, 5),
(55, 2, '/', 19, 5),
(56, 2, '|', 0, 6),
(57, 2, 'P', 1, 6),
(58, 2, '2', 4, 6),
(59, 2, '|', 5, 6),
(60, 2, 'O', 19, 6),
(61, 2, '|', 0, 7),
(62, 2, '|', 5, 7),
(63, 2, '|', 19, 7),
(64, 2, '/', 0, 8),
(65, 2, '-', 1, 8),
(66, 2, '-', 3, 8),
(67, 2, '-', 4, 8),
(68, 2, '/', 5, 8),
(69, 2, '-', 7, 8),
(70, 2, '-', 8, 8),
(71, 2, '-', 9, 8),
(72, 2, '-', 10, 8),
(73, 2, '-', 11, 8),
(74, 2, '/', 12, 8),
(75, 2, '-', 13, 8),
(76, 2, '-', 14, 8),
(77, 2, '-', 15, 8),
(78, 2, '-', 16, 8),
(79, 2, '-', 17, 8),
(80, 2, '-', 18, 8),
(81, 2, '/', 19, 8),
(82, 2, '|', 0, 9),
(83, 2, '|', 12, 9),
(84, 2, '1', 13, 9),
(85, 2, 'P', 18, 9),
(86, 2, '|', 19, 9),
(87, 2, '|', 0, 10),
(88, 2, 'P', 1, 10),
(89, 2, 'B', 18, 10),
(90, 2, '|', 19, 10),
(91, 2, '/', 0, 11),
(92, 2, '-', 1, 11),
(93, 2, '-', 2, 11),
(94, 2, '-', 3, 11),
(95, 2, '-', 4, 11),
(96, 2, '-', 5, 11),
(97, 2, '-', 6, 11),
(98, 2, '-', 7, 11),
(99, 2, '-', 8, 11),
(100, 2, '-', 9, 11),
(101, 2, '-', 10, 11),
(102, 2, '-', 11, 11),
(103, 2, '-', 12, 11),
(104, 2, '-', 13, 11),
(105, 2, '-', 14, 11),
(106, 2, '-', 15, 11),
(107, 2, '-', 16, 11),
(108, 2, '-', 17, 11),
(109, 2, '-', 18, 11),
(110, 2, '/', 19, 11),
(111, 3, '/', 0, 0),
(112, 3, '-', 1, 0),
(113, 3, '-', 2, 0),
(114, 3, '-', 3, 0),
(115, 3, '-', 4, 0),
(116, 3, '/', 5, 0),
(117, 3, '-', 6, 0),
(118, 3, '-', 7, 0),
(119, 3, '-', 8, 0),
(120, 3, '-', 9, 0),
(121, 3, '-', 10, 0),
(122, 3, '-', 11, 0),
(123, 3, '-', 12, 0),
(124, 3, '-', 13, 0),
(125, 3, '-', 14, 0),
(126, 3, '-', 15, 0),
(127, 3, '-', 16, 0),
(128, 3, '-', 17, 0),
(129, 3, '-', 18, 0),
(130, 3, '/', 19, 0),
(131, 3, '|', 0, 1),
(132, 3, '3', 4, 1),
(133, 3, '|', 5, 1),
(134, 3, 'P', 17, 1),
(135, 3, '|', 19, 1),
(136, 3, '|', 0, 2),
(137, 3, '2', 4, 2),
(138, 3, '|', 5, 2),
(139, 3, 'P', 10, 2),
(140, 3, 'L', 18, 2),
(141, 3, 'C', 19, 2),
(142, 3, '|', 0, 3),
(143, 3, '|', 19, 3),
(144, 3, '|', 0, 4),
(145, 3, 'B', 2, 4),
(146, 3, '|', 5, 4),
(147, 3, 'P', 18, 4),
(148, 3, '|', 19, 4),
(149, 3, '/', 0, 5),
(150, 3, '-', 1, 5),
(151, 3, '-', 2, 5),
(152, 3, '-', 3, 5),
(153, 3, '-', 4, 5),
(154, 3, '/', 5, 5),
(155, 3, '-', 6, 5),
(156, 3, '-', 7, 5),
(157, 3, '-', 8, 5),
(158, 3, '-', 11, 5),
(159, 3, '-', 12, 5),
(160, 3, '/', 13, 5),
(161, 3, '-', 14, 5),
(162, 3, '-', 15, 5),
(163, 3, '-', 16, 5),
(164, 3, '-', 17, 5),
(165, 3, '-', 18, 5),
(166, 3, '/', 19, 5),
(167, 3, '|', 0, 6),
(168, 3, 'P', 1, 6),
(169, 3, '|', 5, 6),
(170, 3, '|', 19, 6),
(171, 3, 'O', 0, 7),
(172, 3, '|', 19, 7),
(173, 3, '/', 0, 8),
(174, 3, '-', 1, 8),
(175, 3, '-', 2, 8),
(176, 3, '/', 3, 8),
(177, 3, '/', 7, 8),
(178, 3, '-', 8, 8),
(179, 3, '-', 9, 8),
(180, 3, '-', 10, 8),
(181, 3, '-', 11, 8),
(182, 3, '/', 12, 8),
(183, 3, '-', 13, 8),
(184, 3, '-', 14, 8),
(185, 3, '-', 15, 8),
(186, 3, '-', 16, 8),
(187, 3, '-', 17, 8),
(188, 3, '-', 18, 8),
(189, 3, '/', 19, 8),
(190, 3, '|', 0, 9),
(191, 3, '|', 12, 9),
(192, 3, '4', 13, 9),
(193, 3, 'P', 18, 9),
(194, 3, '|', 19, 9),
(195, 3, '|', 0, 10),
(196, 3, 'P', 1, 10),
(197, 3, 'B', 18, 10),
(198, 3, '|', 19, 10),
(199, 3, '/', 0, 11),
(200, 3, '-', 1, 11),
(201, 3, '-', 2, 11),
(202, 3, '-', 3, 11),
(203, 3, '-', 4, 11),
(204, 3, '-', 5, 11),
(205, 3, '-', 6, 11),
(206, 3, '-', 7, 11),
(207, 3, '-', 8, 11),
(208, 3, '-', 9, 11),
(209, 3, '-', 10, 11),
(210, 3, '-', 11, 11),
(211, 3, '-', 12, 11),
(212, 3, '-', 13, 11),
(213, 3, '-', 14, 11),
(214, 3, '-', 15, 11),
(215, 3, '-', 16, 11),
(216, 3, '-', 17, 11),
(217, 3, '-', 18, 11),
(218, 3, '/', 19, 11),
(219, 4, '/', 0, 0),
(220, 4, '-', 1, 0),
(221, 4, '-', 2, 0),
(222, 4, '-', 3, 0),
(223, 4, '-', 4, 0),
(224, 4, '/', 5, 0),
(225, 4, '-', 6, 0),
(226, 4, '-', 7, 0),
(227, 4, '-', 8, 0),
(228, 4, '-', 9, 0),
(229, 4, '-', 10, 0),
(230, 4, '-', 11, 0),
(231, 4, '-', 12, 0),
(232, 4, '-', 13, 0),
(233, 4, '-', 14, 0),
(234, 4, '-', 15, 0),
(235, 4, '/', 16, 0),
(236, 4, '-', 17, 0),
(237, 4, '-', 18, 0),
(238, 4, '/', 19, 0),
(239, 4, '|', 0, 1),
(240, 4, '3', 8, 1),
(241, 4, '|', 19, 1),
(242, 4, '|', 0, 2),
(243, 4, '|', 5, 2),
(244, 4, '|', 11, 2),
(245, 4, 'B', 18, 2),
(246, 4, '|', 19, 2),
(247, 4, '|', 0, 3),
(248, 4, '|', 5, 3),
(249, 4, '/', 11, 3),
(250, 4, '-', 12, 3),
(251, 4, '-', 13, 3),
(252, 4, '-', 14, 3),
(253, 4, '-', 15, 3),
(254, 4, '-', 16, 3),
(255, 4, '-', 17, 3),
(256, 4, '-', 18, 3),
(257, 4, '/', 19, 3),
(258, 4, 'C', 0, 4),
(259, 4, 'L', 1, 4),
(260, 4, '|', 5, 4),
(261, 4, '1', 11, 4),
(262, 4, '|', 19, 4),
(263, 4, '/', 0, 5),
(264, 4, '-', 1, 5),
(265, 4, '-', 2, 5),
(266, 4, '-', 3, 5),
(267, 4, '-', 4, 5),
(268, 4, '/', 5, 5),
(269, 4, '-', 6, 5),
(270, 4, '-', 7, 5),
(271, 4, '-', 8, 5),
(272, 4, '-', 9, 5),
(273, 4, '-', 10, 5),
(274, 4, '-', 11, 5),
(275, 4, '-', 12, 5),
(276, 4, '-', 13, 5),
(277, 4, '-', 14, 5),
(278, 4, '-', 15, 5),
(279, 4, '-', 16, 5),
(280, 4, '/', 17, 5),
(281, 4, '/', 19, 5),
(282, 4, '|', 0, 6),
(283, 4, '|', 19, 6),
(284, 4, '|', 0, 7),
(285, 4, 'P', 3, 7),
(286, 4, '|', 4, 7),
(287, 4, '|', 19, 7),
(288, 4, '/', 0, 8),
(289, 4, '-', 1, 8),
(290, 4, '-', 2, 8),
(291, 4, '-', 3, 8),
(292, 4, '/', 4, 8),
(293, 4, '/', 19, 8),
(294, 4, '|', 0, 9),
(295, 4, '|', 19, 9),
(296, 4, '|', 0, 10),
(297, 4, '|', 19, 10),
(298, 4, '/', 0, 11),
(299, 4, '-', 1, 11),
(300, 4, '-', 2, 11),
(301, 4, '-', 3, 11),
(302, 4, '-', 4, 11),
(303, 4, '/', 5, 11),
(304, 4, '-', 6, 11),
(305, 4, '-', 7, 11),
(306, 4, '-', 8, 11),
(307, 4, '/', 9, 11),
(308, 4, '-', 10, 11),
(309, 4, '-', 11, 11),
(310, 4, '-', 12, 11),
(311, 4, 'O', 13, 11),
(312, 4, '-', 14, 11),
(313, 4, '-', 15, 11),
(314, 4, '-', 16, 11),
(315, 4, '-', 17, 11),
(316, 4, '-', 18, 11),
(317, 4, '/', 19, 11),
(318, 5, '/', 0, 0),
(319, 5, '-', 1, 0),
(320, 5, '-', 2, 0),
(321, 5, '-', 3, 0),
(322, 5, '-', 4, 0),
(323, 5, '/', 5, 0),
(324, 5, '-', 6, 0),
(325, 5, '-', 7, 0),
(326, 5, '-', 8, 0),
(327, 5, '-', 9, 0),
(328, 5, '-', 10, 0),
(329, 5, '/', 11, 0),
(330, 5, '-', 12, 0),
(331, 5, '-', 13, 0),
(332, 5, '-', 14, 0),
(333, 5, '-', 15, 0),
(334, 5, '/', 16, 0),
(335, 5, '-', 17, 0),
(336, 5, '-', 18, 0),
(337, 5, '/', 19, 0),
(338, 5, '|', 0, 1),
(339, 5, 'P', 2, 1),
(340, 5, '2', 4, 1),
(341, 5, '|', 5, 1),
(342, 5, '|', 11, 1),
(343, 5, 'P', 13, 1),
(344, 5, 'P', 17, 1),
(345, 5, '|', 19, 1),
(346, 5, '/', 0, 2),
(347, 5, '-', 1, 2),
(348, 5, '-', 3, 2),
(349, 5, '-', 4, 2),
(350, 5, '/', 5, 2),
(351, 5, '|', 11, 2),
(352, 5, '1', 16, 2),
(353, 5, 'P', 18, 2),
(354, 5, '|', 19, 2),
(355, 5, '|', 0, 3),
(356, 5, '/', 11, 3),
(357, 5, '-', 12, 3),
(358, 5, '-', 13, 3),
(359, 5, '-', 14, 3),
(360, 5, '-', 15, 3),
(361, 5, '-', 16, 3),
(362, 5, '-', 17, 3),
(363, 5, '-', 18, 3),
(364, 5, '/', 19, 3),
(365, 5, 'O', 0, 4),
(366, 5, '|', 19, 4),
(367, 5, '/', 0, 5),
(368, 5, '|', 19, 5),
(369, 5, '|', 0, 6),
(370, 5, '|', 16, 6),
(371, 5, 'B', 17, 6),
(372, 5, '-', 18, 6),
(373, 5, '/', 19, 6),
(374, 5, '|', 0, 7),
(375, 5, '|', 16, 7),
(376, 5, '|', 19, 7),
(377, 5, '/', 0, 8),
(378, 5, '-', 1, 8),
(379, 5, '-', 2, 8),
(380, 5, '-', 3, 8),
(381, 5, '-', 4, 8),
(382, 5, '-', 5, 8),
(383, 5, '-', 6, 8),
(384, 5, '-', 7, 8),
(385, 5, '-', 8, 8),
(386, 5, '-', 10, 8),
(387, 5, '-', 11, 8),
(388, 5, '-', 12, 8),
(389, 5, '-', 13, 8),
(390, 5, '-', 14, 8),
(391, 5, '-', 15, 8),
(392, 5, '|', 16, 8),
(393, 5, '/', 19, 8),
(394, 5, '|', 0, 9),
(395, 5, 'P', 1, 9),
(396, 5, '|', 16, 9),
(397, 5, '|', 19, 9),
(398, 5, '|', 0, 10),
(399, 5, 'L', 14, 10),
(400, 5, '|', 16, 10),
(401, 5, '4', 17, 10),
(402, 5, '|', 19, 10),
(403, 5, '/', 0, 11),
(404, 5, '-', 1, 11),
(405, 5, '-', 2, 11),
(406, 5, '-', 3, 11),
(407, 5, '-', 4, 11),
(408, 5, '/', 5, 11),
(409, 5, '-', 6, 11),
(410, 5, '-', 7, 11),
(411, 5, '-', 8, 11),
(412, 5, '/', 9, 11),
(413, 5, '-', 10, 11),
(414, 5, '-', 11, 11),
(415, 5, '-', 12, 11),
(416, 5, '-', 13, 11),
(417, 5, 'C', 14, 11),
(418, 5, '-', 15, 11),
(419, 5, '/', 16, 11),
(420, 5, '-', 17, 11),
(421, 5, '-', 18, 11),
(422, 5, '/', 19, 11),
(423, 6, '/', 0, 0),
(424, 6, '-', 1, 0),
(425, 6, '-', 2, 0),
(426, 6, '-', 3, 0),
(427, 6, '-', 4, 0),
(428, 6, '/', 5, 0),
(429, 6, '-', 6, 0),
(430, 6, '-', 7, 0),
(431, 6, '-', 8, 0),
(432, 6, '-', 9, 0),
(433, 6, '-', 10, 0),
(434, 6, '/', 11, 0),
(435, 6, '-', 12, 0),
(436, 6, '-', 13, 0),
(437, 6, '-', 14, 0),
(438, 6, '-', 15, 0),
(439, 6, '/', 16, 0),
(440, 6, '-', 17, 0),
(441, 6, '-', 18, 0),
(442, 6, '/', 19, 0),
(443, 6, '|', 0, 1),
(444, 6, '|', 11, 1),
(445, 6, '-', 12, 1),
(446, 6, '-', 13, 1),
(447, 6, '-', 14, 1),
(448, 6, '-', 15, 1),
(449, 6, '/', 16, 1),
(450, 6, '|', 19, 1),
(451, 6, '/', 0, 2),
(452, 6, 'P', 13, 2),
(453, 6, '|', 16, 2),
(454, 6, 'O', 19, 2),
(455, 6, '|', 0, 3),
(456, 6, '-', 12, 3),
(457, 6, '-', 13, 3),
(458, 6, '-', 14, 3),
(459, 6, '-', 15, 3),
(460, 6, '/', 16, 3),
(461, 6, '-', 17, 3),
(462, 6, '/', 19, 3),
(463, 6, '|', 0, 4),
(464, 6, '|', 10, 4),
(465, 6, '|', 19, 4),
(466, 6, '/', 0, 5),
(467, 6, '/', 10, 5),
(468, 6, '-', 11, 5),
(469, 6, '-', 12, 5),
(470, 6, '-', 13, 5),
(471, 6, '-', 14, 5),
(472, 6, '-', 15, 5),
(473, 6, '-', 16, 5),
(474, 6, '-', 17, 5),
(475, 6, '-', 18, 5),
(476, 6, '/', 19, 5),
(477, 6, '|', 0, 6),
(478, 6, '/', 19, 6),
(479, 6, '|', 0, 7),
(480, 6, '/', 16, 7),
(481, 6, '|', 19, 7),
(482, 6, '/', 0, 8),
(483, 6, '|', 16, 8),
(484, 6, '1', 18, 8),
(485, 6, '/', 19, 8),
(486, 6, '|', 0, 9),
(487, 6, '-', 1, 9),
(488, 6, '-', 2, 9),
(489, 6, '-', 3, 9),
(490, 6, '-', 4, 9),
(491, 6, '-', 5, 9),
(492, 6, '-', 6, 9),
(493, 6, '-', 7, 9),
(494, 6, '-', 8, 9),
(495, 6, '-', 9, 9),
(496, 6, '-', 10, 9),
(497, 6, '-', 11, 9),
(498, 6, '-', 12, 9),
(499, 6, '-', 13, 9),
(500, 6, '-', 14, 9),
(501, 6, '-', 15, 9),
(502, 6, '/', 16, 9),
(503, 6, '2', 17, 9),
(504, 6, '3', 18, 9),
(505, 6, '|', 19, 9),
(506, 6, 'C', 0, 10),
(507, 6, 'L', 1, 10),
(508, 6, '4', 18, 10),
(509, 6, '|', 19, 10),
(510, 6, '/', 0, 11),
(511, 6, '-', 1, 11),
(512, 6, '/', 2, 11),
(513, 6, '-', 3, 11),
(514, 6, '-', 4, 11),
(515, 6, '/', 5, 11),
(516, 6, '-', 6, 11),
(517, 6, '-', 7, 11),
(518, 6, '/', 8, 11),
(519, 6, '-', 9, 11),
(520, 6, '-', 10, 11),
(521, 6, '/', 11, 11),
(522, 6, '-', 12, 11),
(523, 6, '/', 13, 11),
(524, 6, '-', 14, 11),
(525, 6, '/', 15, 11),
(526, 6, '-', 16, 11),
(527, 6, '-', 17, 11),
(528, 6, '-', 18, 11),
(529, 6, '/', 19, 11);

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
(1, 'Test', 12, 20),
(2, 'Level2', 12, 20),
(3, 'Level3', 12, 20),
(4, 'Level4', 12, 20),
(5, 'Level5', 12, 20),
(6, 'Level6', 12, 20);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `contenir`
--
ALTER TABLE `contenir`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Level` (`levelnumber`),
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=530;
--
-- AUTO_INCREMENT pour la table `level`
--
ALTER TABLE `level`
  MODIFY `number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `contenir`
--
ALTER TABLE `contenir`
  ADD CONSTRAINT `identifierfk` FOREIGN KEY (`identifier`) REFERENCES `element` (`identifier`),
  ADD CONSTRAINT `levelfk` FOREIGN KEY (`levelnumber`) REFERENCES `level` (`number`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;