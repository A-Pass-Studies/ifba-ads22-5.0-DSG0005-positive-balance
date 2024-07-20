package com.apass.collegeifba.s50.dsg005.positivebalance.data.auth

interface AuthRepository {

    suspend fun login(auth: AuthRequest): AuthResponse
}