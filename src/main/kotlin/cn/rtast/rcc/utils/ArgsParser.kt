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


package cn.rtast.rcc.utils

import cn.rtast.rcc.models.Config
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import kotlinx.cli.required

class ArgsParser(private val args: Array<String>) {

    private val parser = ArgParser("RCC")

    fun parse(): Config {
        val host by parser.option(
            ArgType.String,
            fullName = "host",
            description = "Host to listen"
        ).default("0.0.0.0")

        val port by parser.option(
            ArgType.Int,
            fullName = "port",
            description = "Port to listen"
        ).default(25575)

        val password by parser.option(
            ArgType.String,
            fullName = "pwd",
            description = "Password"
        ).required()

        parser.parse(args)
        return Config(host, port, password)
    }
}