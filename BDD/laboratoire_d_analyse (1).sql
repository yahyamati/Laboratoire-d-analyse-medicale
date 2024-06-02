-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2024 at 07:21 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laboratoire_d_analyse`
--

-- --------------------------------------------------------

--
-- Table structure for table `analyse`
--

CREATE TABLE `analyse` (
  `ID_analyse` int(11) NOT NULL,
  `Nom_analyse` varchar(255) DEFAULT NULL,
  `Prix_analyse` decimal(10,2) DEFAULT NULL,
  `norme` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `analyse`
--

INSERT INTO `analyse` (`ID_analyse`, `Nom_analyse`, `Prix_analyse`, `norme`) VALUES
(1, 'VIH', 1200.00, '1'),
(2, 'Biologie', 800.00, '2'),
(3, 'Biochimie', 750.00, '4'),
(4, 'Creatine', 1000.00, '3');

-- --------------------------------------------------------

--
-- Table structure for table `bilan`
--

CREATE TABLE `bilan` (
  `ID_bilan` int(11) NOT NULL,
  `ID_patient` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bilan`
--

INSERT INTO `bilan` (`ID_bilan`, `ID_patient`) VALUES
(1, 11);

-- --------------------------------------------------------

--
-- Table structure for table `biologiste`
--

CREATE TABLE `biologiste` (
  `Id_biologiste` int(11) NOT NULL,
  `Nom_biologiste` varchar(255) DEFAULT NULL,
  `Prenom_biologiste` varchar(255) DEFAULT NULL,
  `Email_biologiste` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `biologiste`
--

INSERT INTO `biologiste` (`Id_biologiste`, `Nom_biologiste`, `Prenom_biologiste`, `Email_biologiste`) VALUES
(1, 'belmahnouf', 'loukmane', 'loukmane@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `dossiers`
--

CREATE TABLE `dossiers` (
  `ID_Dossier` int(11) NOT NULL,
  `id_patient` int(11) DEFAULT NULL,
  `pdf` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dossiers`
--

INSERT INTO `dossiers` (`ID_Dossier`, `id_patient`, `pdf`) VALUES
(1, 11, 0x255044462d312e340a25e2e3cfd30a332030206f626a0a3c3c2f4c656e677468203730332f46696c7465722f466c6174654465636f64653e3e73747265616d0a789c95564b6edb3010ddeb14dc252d60977f495d356dd2a00512b4a82ec048b44383221d4a4ad39caa47ead6b708695b49a34f2caf4848f3de9b7933a278177dce22c2410239c88a08825942f61b9484cd87af08200cb245747a295c211df80756b671404b50d8aa52fe8950a652e0ae912097cd032864054a59de38bf1612dcdbda49b010a5d25abe7f97ad3c39ec68e056e36cbdb6ae968f334f2fee65eed14de525f589cd7351296b4071d218af644dd5e85ad4e151b929542eb49c0fb19f82d74f49bb49f958166308743482e06311349982b8c8a29fd15d04e79ca41803388f194fb85f134653e096a1a7312780610228014e468b03c1781f0c77c1811d83ef5eefd2effd902010a411a03e36f633526e47c323b2c00ca1a7f68c18c7940566bfa0407d7abe1f927d8f76352c43011d52f2420a0f91aea5abac31f27fba036ef857db02c9c10229e0346e7341f4502e5fac75854f66e3c7fd392f2dab57a98daa910470cc766acf9dbeb6e5c7007f6d124ed3391b88fe2db42afae18119a69dd81f4e9ab7c87b80717296924eecb9a865f8e28d5055254c2e4775fa580c219a213483e9b0581c7700bfe4c31bfcbdf0ab615a8e3a7117a5507a9cb717bff5e7d332a0e6b92d875568b765d9466fd6b7d68433b454b9d26f94d20343c679ca28266c8f3930f9346593279f4172cce49b5ae4753891dd52fa7e4f1e799a747dbc6eca8db3617aea176f5ade5173fa3c90738e8237f14473089a6c0e25e97473ceaaaa71e12300a5d0a250479883bac37bfdd77b215ac271377a400431410c63cc28a20c0f4e27855d0fbf998575e5f6d75a4d13ee519846eb690d206c7a03083ba20157bb8b81cc95996c3d213deb6d098aa6251a75a00fccc41f71336838c15db79e8f8371fe1ea6948f4a1835ac00bb67c659e16f63d5f674d602e45a1915ee6bedc5695cb7c7043963882638142c6efd8f7da556b2edf51367e866320a656e6473747265616d0a656e646f626a0a352030206f626a0a3c3c2f547970652f506167652f4d65646961426f785b30203020353935203834325d2f5265736f75726365733c3c2f466f6e743c3c2f46312031203020522f46322032203020523e3e3e3e2f436f6e74656e74732033203020522f506172656e742034203020523e3e0a656e646f626a0a312030206f626a0a3c3c2f547970652f466f6e742f537562747970652f54797065312f42617365466f6e742f48656c7665746963612d426f6c642f456e636f64696e672f57696e416e7369456e636f64696e673e3e0a656e646f626a0a322030206f626a0a3c3c2f547970652f466f6e742f537562747970652f54797065312f42617365466f6e742f48656c7665746963612f456e636f64696e672f57696e416e7369456e636f64696e673e3e0a656e646f626a0a342030206f626a0a3c3c2f547970652f50616765732f436f756e7420312f4b6964735b35203020525d3e3e0a656e646f626a0a362030206f626a0a3c3c2f547970652f436174616c6f672f50616765732034203020523e3e0a656e646f626a0a372030206f626a0a3c3c2f50726f6475636572286954657874ae20352e352e3920a9323030302d323031352069546578742047726f7570204e56205c284147504c2d76657273696f6e5c29292f4372656174696f6e4461746528443a32303234303532333231343733372b303127303027292f4d6f644461746528443a32303234303532333231343733372b303127303027293e3e0a656e646f626a0a787265660a3020380a303030303030303030302036353533352066200a30303030303030393036203030303030206e200a30303030303030393939203030303030206e200a30303030303030303135203030303030206e200a30303030303031303837203030303030206e200a30303030303030373835203030303030206e200a30303030303031313338203030303030206e200a30303030303031313833203030303030206e200a747261696c65720a3c3c2f53697a6520382f526f6f742036203020522f496e666f2037203020522f4944205b3c36396162336432346236323962613832633439336166313666323864643866353e3c36396162336432346236323962613832633439336166313666323864643866353e5d3e3e0a2569546578742d352e352e390a7374617274787265660a313334300a2525454f460a);

-- --------------------------------------------------------

--
-- Table structure for table `dépenses`
--

CREATE TABLE `dépenses` (
  `Date` date NOT NULL,
  `Montant_dépenses` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `echantillion`
--

CREATE TABLE `echantillion` (
  `Code_échantillion` varchar(255) NOT NULL,
  `Id_patient` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `echantillion`
--

INSERT INTO `echantillion` (`Code_échantillion`, `Id_patient`) VALUES
('11wwM0920240523-1,2,3,4', 11);

-- --------------------------------------------------------

--
-- Table structure for table `gerant`
--

CREATE TABLE `gerant` (
  `Id_gerant` int(11) NOT NULL,
  `Nom_gerant` varchar(255) DEFAULT NULL,
  `Prenom_gerant` varchar(255) DEFAULT NULL,
  `Email_gerant` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `gerant`
--

INSERT INTO `gerant` (`Id_gerant`, `Nom_gerant`, `Prenom_gerant`, `Email_gerant`) VALUES
(1, 'Doe', 'John', 'john.doe@example.com');

-- --------------------------------------------------------

--
-- Table structure for table `medecin`
--

CREATE TABLE `medecin` (
  `Id_medecin` int(11) NOT NULL,
  `Nom_medecin` varchar(255) DEFAULT NULL,
  `Prenom_medecin` varchar(255) DEFAULT NULL,
  `Email_medecin` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `medecin`
--

INSERT INTO `medecin` (`Id_medecin`, `Nom_medecin`, `Prenom_medecin`, `Email_medecin`) VALUES
(1, 'Yahya', 'Mati', 'yahya@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `Id_patient` int(11) NOT NULL,
  `Nom_patient` varchar(255) DEFAULT NULL,
  `Prenom_patient` varchar(255) DEFAULT NULL,
  `Date_naissance_patient` date DEFAULT NULL,
  `Sexe` char(1) DEFAULT NULL,
  `Email_patient` varchar(255) DEFAULT NULL,
  `Num_telephone_patient` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`Id_patient`, `Nom_patient`, `Prenom_patient`, `Date_naissance_patient`, `Sexe`, `Email_patient`, `Num_telephone_patient`) VALUES
(1, 'yahya', 'matii', '2003-04-07', 'M', 'yahya@mati.com', '07070707070'),
(2, 'kafaty', 'pirloo', '2002-07-17', 'M', 'pirlo@kafaty.com', '07070707070'),
(3, 'belmehnouf', 'loukman', '2003-12-04', 'M', 'kkk@kkk.com', '0909090'),
(4, 'jlkjl', 'kllklklklkl', '2000-02-23', 'M', 'opopoop@gmail.com', 'popo'),
(5, 'aaaa', 'aaaa', '2003-01-01', 'M', 'aaa@gmail.com', '006106102'),
(6, 'bbb', 'bbb', '2003-01-01', 'M', 'bbb@gmail.com', '0256545415'),
(7, 'ccc', 'ccc', '2003-01-01', 'M', 'ccc@gmail.com', '064605604'),
(8, 'ggg', 'gggg', '2004-01-03', 'M', 'ggg@gmail.com', '0695263056'),
(9, 'arara', 'rarar', '2003-01-01', 'M', 'yahya@gmail.com', '506456054604'),
(10, 'bouchair', 'rayane', '2003-01-05', 'M', 'rayane@gmail.com', '066060606'),
(11, 'walid', 'walid', '2001-11-09', 'M', 'walid@gmail.com', '0566954235');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Id_payment` int(11) NOT NULL,
  `Date_payment` date DEFAULT NULL,
  `Id_patient` int(11) DEFAULT NULL,
  `Montant_paye` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`Id_payment`, `Date_payment`, `Id_patient`, `Montant_paye`) VALUES
(11, '2024-05-23', 3, 1000.00),
(16, '2024-05-23', 7, 1000.00),
(23, '2024-05-23', 8, 2000.00),
(51, '2024-05-31', 10, 1000.00),
(55, '2024-05-31', 4, 2000.00),
(58, '2024-05-24', 1, 1000.00),
(72, '2024-04-25', 11, 3000.00),
(78, '2024-05-24', 11, 1000.00),
(79, '2024-05-24', 11, 1000.00),
(80, '2024-05-24', 11, 1000.00),
(81, '2024-05-24', 11, 1000.00),
(82, '2024-05-24', 11, 100.00),
(83, '2024-05-24', 10, 100.00),
(84, '2024-05-24', 11, 1000.00),
(85, '2024-05-24', 11, 1000.00),
(86, '2024-05-24', 10, 1000.00),
(87, '2024-05-24', 11, 80.00),
(88, '2024-05-24', 10, 10.00),
(95, '2024-05-24', 11, 1000.00),
(96, '2024-05-25', 11, 1000.00);

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

CREATE TABLE `produit` (
  `Id_produit` int(11) NOT NULL,
  `Nom_produit` varchar(255) DEFAULT NULL,
  `Quantite_produit` int(11) DEFAULT NULL,
  `Date_peremption` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `receptionniste`
--

CREATE TABLE `receptionniste` (
  `Id_receptionniste` int(11) NOT NULL,
  `Nom_receptionniste` varchar(255) DEFAULT NULL,
  `Prenom_receptionniste` varchar(255) DEFAULT NULL,
  `Email_receptionniste` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `receptionniste`
--

INSERT INTO `receptionniste` (`Id_receptionniste`, `Nom_receptionniste`, `Prenom_receptionniste`, `Email_receptionniste`) VALUES
(14, 'Rayane', 'Bouchair', 'rayane@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `rendez_vous`
--

CREATE TABLE `rendez_vous` (
  `Id_rendez_vous` int(11) NOT NULL,
  `Id_patient` int(11) DEFAULT NULL,
  `Date_rendez_vous` date DEFAULT NULL,
  `Heur_rendez_vous` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rendez_vous`
--

INSERT INTO `rendez_vous` (`Id_rendez_vous`, `Id_patient`, `Date_rendez_vous`, `Heur_rendez_vous`) VALUES
(1, 11, '2024-05-24', '9h_15min'),
(2, 1, '2024-05-29', '8h_30min');

-- --------------------------------------------------------

--
-- Table structure for table `revenus1`
--

CREATE TABLE `revenus1` (
  `Date` date NOT NULL,
  `journee_revenus` decimal(10,2) DEFAULT NULL,
  `semain_revenus` double DEFAULT 0,
  `month_revenus` double DEFAULT 0,
  `week_of_year` int(11) DEFAULT NULL,
  `month_of_year` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `revenus1`
--

INSERT INTO `revenus1` (`Date`, `journee_revenus`, `semain_revenus`, `month_revenus`, `week_of_year`, `month_of_year`) VALUES
('2024-04-25', 5000.00, 8000, 8000, 17, 4),
('2024-04-26', 3000.00, 4000, 4000, 17, 4),
('2024-05-24', 1000.00, 58290, 59290, 21, 5),
('2024-05-25', 1000.00, 1000, 1000, 21, 5),
('2024-05-26', 1000.00, 1000, 1000, 22, 5),
('2024-05-27', 1000.00, 1000, 1000, 22, 5),
('2024-05-28', 2000.00, 2000, 2000, 22, 5),
('2024-05-29', 1000.00, 1000, 1000, 22, 5),
('2024-05-30', 2000.00, 2000, 2000, 22, 5),
('2024-05-31', 1000.00, 25000, 25000, 22, 5);

-- --------------------------------------------------------

--
-- Table structure for table `résultat`
--

CREATE TABLE `résultat` (
  `ID_resultat` int(11) NOT NULL,
  `ID_bilan` int(11) DEFAULT NULL,
  `ID_Analyse` int(11) DEFAULT NULL,
  `resultat` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `résultat`
--

INSERT INTO `résultat` (`ID_resultat`, `ID_bilan`, `ID_Analyse`, `resultat`) VALUES
(1, 1, 1, '1'),
(2, 1, 2, '2'),
(3, 1, 3, '3'),
(4, 1, 4, '2');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `Id_utilisateur` int(11) NOT NULL,
  `Nom_utilisateur` varchar(255) DEFAULT NULL,
  `Prenom_utilisateur` varchar(255) DEFAULT NULL,
  `Date_naissance_utilisateur` date DEFAULT NULL,
  `Sexe` char(1) DEFAULT NULL,
  `Email_utilisateur` varchar(255) DEFAULT NULL,
  `Num_telephone_utilisateur` varchar(20) DEFAULT NULL,
  `Mot_passe` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`Id_utilisateur`, `Nom_utilisateur`, `Prenom_utilisateur`, `Date_naissance_utilisateur`, `Sexe`, `Email_utilisateur`, `Num_telephone_utilisateur`, `Mot_passe`) VALUES
(1, 'Doe', 'John', '1990-01-01', 'M', 'john.doe@example.com', '1234567890', 'jDoe!2024'),
(48, 'Yahya', 'Mati', '2003-08-09', 'M', 'yahya@gmail.com', '0660262588', 'yahya123'),
(49, 'belmahnouf', 'loukmane', '2003-05-06', 'M', 'loukmane@gmail.com', '0526458566', 'loukmane2003'),
(50, 'Rayane', 'Bouchair', '2003-10-02', 'M', 'rayane@gmail.com', '0725669812', 'rayane2003');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `analyse`
--
ALTER TABLE `analyse`
  ADD PRIMARY KEY (`ID_analyse`);

--
-- Indexes for table `bilan`
--
ALTER TABLE `bilan`
  ADD PRIMARY KEY (`ID_bilan`),
  ADD KEY `ID_patient` (`ID_patient`);

--
-- Indexes for table `biologiste`
--
ALTER TABLE `biologiste`
  ADD PRIMARY KEY (`Id_biologiste`);

--
-- Indexes for table `dossiers`
--
ALTER TABLE `dossiers`
  ADD PRIMARY KEY (`ID_Dossier`),
  ADD KEY `id_patient` (`id_patient`);

--
-- Indexes for table `dépenses`
--
ALTER TABLE `dépenses`
  ADD PRIMARY KEY (`Date`);

--
-- Indexes for table `echantillion`
--
ALTER TABLE `echantillion`
  ADD PRIMARY KEY (`Code_échantillion`),
  ADD KEY `fk_patient` (`Id_patient`);

--
-- Indexes for table `gerant`
--
ALTER TABLE `gerant`
  ADD PRIMARY KEY (`Id_gerant`);

--
-- Indexes for table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`Id_medecin`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`Id_patient`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Id_payment`),
  ADD KEY `Id_patient` (`Id_patient`);

--
-- Indexes for table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`Id_produit`);

--
-- Indexes for table `receptionniste`
--
ALTER TABLE `receptionniste`
  ADD PRIMARY KEY (`Id_receptionniste`);

--
-- Indexes for table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD PRIMARY KEY (`Id_rendez_vous`),
  ADD KEY `Id_patient` (`Id_patient`);

--
-- Indexes for table `revenus1`
--
ALTER TABLE `revenus1`
  ADD PRIMARY KEY (`Date`),
  ADD UNIQUE KEY `Date` (`Date`);

--
-- Indexes for table `résultat`
--
ALTER TABLE `résultat`
  ADD PRIMARY KEY (`ID_resultat`),
  ADD KEY `ID_bilan` (`ID_bilan`),
  ADD KEY `ID_Analyse` (`ID_Analyse`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`Id_utilisateur`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `analyse`
--
ALTER TABLE `analyse`
  MODIFY `ID_analyse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `bilan`
--
ALTER TABLE `bilan`
  MODIFY `ID_bilan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `biologiste`
--
ALTER TABLE `biologiste`
  MODIFY `Id_biologiste` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `dossiers`
--
ALTER TABLE `dossiers`
  MODIFY `ID_Dossier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `gerant`
--
ALTER TABLE `gerant`
  MODIFY `Id_gerant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `medecin`
--
ALTER TABLE `medecin`
  MODIFY `Id_medecin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `Id_patient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `Id_payment` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;

--
-- AUTO_INCREMENT for table `produit`
--
ALTER TABLE `produit`
  MODIFY `Id_produit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `receptionniste`
--
ALTER TABLE `receptionniste`
  MODIFY `Id_receptionniste` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  MODIFY `Id_rendez_vous` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `résultat`
--
ALTER TABLE `résultat`
  MODIFY `ID_resultat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `Id_utilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bilan`
--
ALTER TABLE `bilan`
  ADD CONSTRAINT `bilan_ibfk_1` FOREIGN KEY (`ID_patient`) REFERENCES `patient` (`Id_patient`);

--
-- Constraints for table `dossiers`
--
ALTER TABLE `dossiers`
  ADD CONSTRAINT `dossiers_ibfk_1` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`Id_patient`);

--
-- Constraints for table `echantillion`
--
ALTER TABLE `echantillion`
  ADD CONSTRAINT `fk_patient` FOREIGN KEY (`Id_patient`) REFERENCES `patient` (`Id_patient`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`Id_patient`) REFERENCES `patient` (`Id_patient`);

--
-- Constraints for table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD CONSTRAINT `rendez_vous_ibfk_1` FOREIGN KEY (`Id_patient`) REFERENCES `patient` (`Id_patient`);

--
-- Constraints for table `résultat`
--
ALTER TABLE `résultat`
  ADD CONSTRAINT `résultat_ibfk_2` FOREIGN KEY (`ID_Analyse`) REFERENCES `analyse` (`ID_analyse`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
