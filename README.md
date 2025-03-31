# Multi-Threaded Inventory Manager

A Java-based inventory management system that simulates real-time stock updates using multi-threading and a MySQL database.


## Overview

This project demonstrates how to manage product inventory in a multi-threaded environment. It simulates multiple stores selling products concurrently and updates the stock levels in a database using JDBC. The system ensures thread safety by using synchronized methods to handle concurrent updates.

## Features

- **Multi-Threaded Simulation**: Simulates multiple stores selling products concurrently.
- **Database Integration**: Uses MySQL to store and update product stock levels.
- **Thread Safety**: Ensures safe concurrent updates using `synchronized` methods.
- **Dynamic Stock Updates**: Randomly generates sales quantities to simulate real-world scenarios.

## Technologies Used

- **Java**: Core programming language.
- **JDBC**: For database connectivity.
- **MySQL**: Database to store product information.
- **Multi-Threading**: To simulate concurrent sales.

## Prerequisites

Before running the project, ensure you have the following installed:

1. **Java Development Kit (JDK)**: Version 8 or higher.
2. **MySQL**: Installed and running locally or remotely.
3. **MySQL Connector/J**: JDBC driver for MySQL (included in the project or downloaded separately).

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/birdiey/Multi-Threaded-Inventory-Manager.git
   cd Multi-Threaded-Inventory-Manager
