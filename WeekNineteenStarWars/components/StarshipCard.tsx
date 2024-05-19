'use client';
import { useState, useEffect } from 'react';
import { useRouter } from 'next/navigation';
import instance from '@/lib/axios';

interface StarshipCardProps {
  starship: {
    id: number;
    name: string;
    model: string;
    hyperdrive_rating: string;
    url: string;
  };
}

const StarshipCard: React.FC<StarshipCardProps> = ({ starship }) => {

  const router = useRouter();

  const onClick = (id: number) => {
    router.push(`/starships/${id}`);
  };

  return (
    <div className="border p-4 m-2 rounded shadow" onClick={() => onClick(starship.id)} title={'id: ' + starship.id}>
      <h2 className="text-xl font-bold">{starship.name}</h2>
      <p>Model: {starship.model}</p>
      <p>Hyperdrive Rating: {starship.hyperdrive_rating}</p>
    </div>
  );
};

export default StarshipCard;
