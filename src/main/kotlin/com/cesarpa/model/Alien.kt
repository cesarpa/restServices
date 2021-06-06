package com.cesarpa.model

import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class Alien(var id:Int, var name: String, var points: Int)