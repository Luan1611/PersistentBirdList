package br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist

import androidx.lifecycle.ViewModel
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.model.Bird
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.model.Bird.Companion.ID_AVE_INVALIDO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BirdViewModel: ViewModel() {
    private val _aveAtual = MutableStateFlow(Bird())

    val aveAtual: StateFlow<Bird> = _aveAtual.asStateFlow()
    private val _birdList: MutableStateFlow<List<Bird>> = MutableStateFlow(value = emptyList())

    val birdList: StateFlow<List<Bird>> = _birdList.asStateFlow()

    private var proximoIdAve = 0

    fun saveBird(bird: Bird) {

        if (bird.id == ID_AVE_INVALIDO) {

            val novaAve = bird.copy(id = proximoIdAve++)

            _birdList.update { listaAves -> listaAves + novaAve }

        }
        else {
            _birdList.update{
                listaAves -> listaAves.map{
                    aveIteracaoAtual ->
                if (aveIteracaoAtual.id == bird.id) bird
                else aveIteracaoAtual
                }
            }
        }

    }

}