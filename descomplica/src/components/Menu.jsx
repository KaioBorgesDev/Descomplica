import React, { useState } from 'react';
import "./Menu.css";

const Menu = () => {
  const [isFormVisible, setIsFormVisible] = useState(false);

  const toggleFormVisibility = () => {
    setIsFormVisible(!isFormVisible);
  };

  return (
    <div className='header'>
      <a href=""> <img src="logo_verde.svg" alt="logo" srcSet=""/></a>
      <a href="">Enem e Vestibular</a>
      <a href="">Parceria TIM</a>
      <a href="">Graduação</a>
      <a href="">Pós</a>
      <a href="">Cursos livres</a>
      <a href="">Para empresas</a>
      {!isFormVisible && (
        <a href="">
          <button onClick={toggleFormVisibility}>Já sou aluno</button>
        </a>
      )}
    </div>
  );
}

export default Menu;