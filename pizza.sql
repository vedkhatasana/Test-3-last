-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2025 at 05:44 PM
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
-- Database: `pizza`
--

-- --------------------------------------------------------

--
-- Table structure for table `pizza_orders`
--

CREATE TABLE `pizza_orders` (
  `id` int(11) NOT NULL,
  `customerName` varchar(100) NOT NULL,
  `mobileNumber` varchar(20) NOT NULL,
  `pizzaSize` varchar(10) NOT NULL,
  `numberOfToppings` int(11) NOT NULL,
  `totalBill` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pizza_orders`
--

INSERT INTO `pizza_orders` (`id`, `customerName`, `mobileNumber`, `pizzaSize`, `numberOfToppings`, `totalBill`) VALUES
(1, 'Vedant Kumar', '9876543210', 'L', 2, 15.53),
(2, 'Amit Sharma', '9123456789', 'XL', 0, 17.25),
(3, 'Priya Singh', '9988776655', 'M', 5, 19.55),
(4, 'Riya Patel', '9001122334', 'S', 1, 10.93),
(5, 'John Doe', '8001234567', 'L', 3, 17.25);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pizza_orders`
--
ALTER TABLE `pizza_orders`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pizza_orders`
--
ALTER TABLE `pizza_orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
