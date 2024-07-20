package com.apass.collegeifba.s50.dsg005.positivebalance.data.auth

import android.net.Uri

class AuthFakeRepository: AuthRepository {

    override suspend fun login(auth: AuthRequest): AuthResponse {
        return AuthResponse("Anderson", Uri.parse("https://wp-content.bluebus.com.br/wp-content/uploads/2017/03/31142426/twitter-novo-avatar-padrao-2017-bluebus.png/"))
    }
}