package br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Bird(
    val id: Int = ID_AVE_INVALIDO,
    val nome: String = "",
    val especie: String = "",
    val idade: String = ""
): Parcelable {
    companion object {
        const val ID_AVE_INVALIDO = -1
    }
}