import React from 'react'
import CardItem from './CardItem';
import './Cards.css';

function Cards() {
  return (
    <div className='cards'>
      <h1>Check out these popular dishes!</h1>
      <div className='cards__container'>
        <div className='cards__wrapper'>
          <ul className='cards__items'>
            <CardItem
              src=''
              text=''
              label='Dessert'
              path='/recipes'
            />
            <CardItem
              src=''
              text=''
              label='Savory'
              path='/recipes'
            />
          </ul>
        </div>
      </div>
    </div>
  )
}

export default Cards