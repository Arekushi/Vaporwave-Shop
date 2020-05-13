package br.com.arekushi.vaporwaveshop.database

class DatabaseOptions {

    companion object {
        const val databaseName = "vaporwave.db"
        const val databaseVersion = 1

        /* TABLES */
        const val tbUser = "tbUser"
        private const val idUser = "idUser"
        const val emailUser = "emailUser"
        const val passwordUser = "passwordUser"

        /* CREATE TABLE QUERY */
        const val createTableUser =
            ("CREATE TABLE $tbUser (" +
                "$idUser INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", $emailUser TEXT" +
                ", $passwordUser TEXT" +
            ")")
    }
}