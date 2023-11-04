/*
 * Copyright 2023 RTAkland
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */


package cn.rtast.rcc

import cn.rtast.rcc.utils.ArgsParser
import cn.rtast.rcc.utils.RCon
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val conf = ArgsParser(args).parse()
    val rcon = RCon(conf.host, conf.port)
    rcon.authenticate(conf.password)
    println("Type :quit to exit.")
    while (true) {
        print("Command >>")
        val input = readlnOrNull()
        if (input == null) {
            println("Please input command")
        } else {
            if (input == ":quit") {
                exitProcess(0)
            } else {
                val response = rcon.executeCommand(input)
                println("Response >> ${response.body}")
            }
        }
    }
}