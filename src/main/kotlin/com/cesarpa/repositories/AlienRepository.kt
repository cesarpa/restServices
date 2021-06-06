package com.cesarpa.repositories

import com.cesarpa.model.Alien
import java.sql.*;

class AlienRepository {
    var alienList: MutableList<Alien>? = mutableListOf()
    var con: Connection? = null

    init {
        var url = "jdbc:mysql://localhost:3306/restdb"
        var user = "admin"
        var password = "admin"
        Class.forName("com.mysql.cj.jdbc.Driver")
        con = DriverManager.getConnection(url, user, password)
    }

    fun getAlienData(): MutableList<Alien>? {
        alienList?.clear()
        var sql = "select * from alien"
        var st: Statement? = con?.createStatement()
        var rs: ResultSet? = st?.executeQuery(sql)
        while (rs?.next()!!) {
            var a: Alien = Alien(rs.getInt(1), rs.getString(2), rs.getInt(3))
            alienList?.add(a)
        }
        return alienList
    }

    fun getAlienById(id: Int): Alien? {
        var sql = "select * from alien where id=$id"
        var st: Statement? = con?.createStatement()
        var rs: ResultSet? = st?.executeQuery(sql)
        if (rs?.next()!!) {
            return Alien(rs.getInt(1), rs.getString(2), rs.getInt(3))

        }
        return null
    }

    fun createAlien(a: Alien) {
        var sql = "insert into alien values (?,?,?)"
        var st: PreparedStatement? = con?.prepareStatement(sql)
        st?.setInt(1, a.id)
        st?.setString(2, a.name)
        st?.setInt(3, a.points)
        st?.executeUpdate()
    }


    fun updateAlien(a: Alien) {
        var sql = "update alien set name=?, points=? where id=?"
        var st: PreparedStatement? = con?.prepareStatement(sql)

        st?.setString(1, a.name)
        st?.setInt(2, a.points)
        st?.setInt(3, a.id)

        st?.executeUpdate()
    }

    fun deleteAlien(id: Int) {
        var sql = "delete from alien where id=?"
        var st: PreparedStatement? = con?.prepareStatement(sql)
        st?.setInt(1, id)
        st?.executeUpdate()
    }


}