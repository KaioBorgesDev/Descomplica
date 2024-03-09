import React from 'react'
import "./Card.css"
const Card = ({preco, porcento}) => {
  return (
    <div className='card'>
     <h2><b>Descomplica </b></h2>
     <h2>Top Medicina</h2>

        <h5>De</h5>
        <h5>12x R${preco}</h5> <h5>por até</h5>
        
        <h4>{porcento}% OFF</h4>
            
        <button type="button">Comprar agora</button>
    </div>
  )
}

export default Card