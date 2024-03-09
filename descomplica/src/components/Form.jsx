import React from 'react';
import './Form.css';

const Form = () => {
  return (
    <div className="form-container">
      <h2>Entre em Contato</h2>
      <form>
        <div className="form-group">
          <label htmlFor="name">Nome:</label>
          <input type="text" id="name" name="name" placeholder="Digite seu nome" />
        </div>
        <div className="form-group">
          <label htmlFor="email">Email:</label>
          <input type="email" id="email" name="email" placeholder="Digite seu email" />
        </div>
        <div className="form-group">
          <label htmlFor="message">Mensagem:</label>
          <textarea id="message" name="message" rows="4" placeholder="Digite sua mensagem"></textarea>
        </div>
        <button type="submit">Enviar</button>
      </form>
    </div>
  );
}

export default Form;