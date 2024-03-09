import React from 'react'
import "./Aside.css"
import Card from './Card'
const Aside = () => {
  return (
    <div className='aside'>
        <div>
        <p>
            Cursinho e Pré-vestibular Enem
        </p>
        <h1>
            BORA FICAR GRANDÃO PARA O ENEM 2024?
        </h1>
        <p>Garanta sua preparação e comece a estudar do zero!</p>

         <p class="h1_saiba"><a href="">Saiba mais sobre os planos</a></p>
         </div>

         <img src="IMG-mobile.png" alt="" srcset="imagem da mulher-sentada"/>

        <Card preco = {100.00} porcento = {50}></Card>
    </div>
  )
}

export default Aside