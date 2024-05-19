'use client';
import { useRouter } from 'next/navigation';
import { useState, useEffect } from 'react';
import instance from '@/lib/axios';

interface Starship {
  name: string;
  model: string;
  manufacturer: string;
  passengers: string;
  max_atmosphering_speed: string;
  crew: string;
  cargo_capacity: string;
}

export default function StarshipDetail({ params } : { params: { id: string } }) {

  const router = useRouter();
  const [starship, setStarship] = useState<Starship | null>(null);

  useEffect(() => {
    if (params.id) {
      console.log("params.id: ", params.id); // "1
      instance.get(`/starships/${params.id}/`)
        .then((res) => {
          setStarship(res.data);
          console.log(res.data);
        })
        .catch((err) => {
          console.error(err);
        });
    }
  }, [params.id]);

  return (
    <div className="container mx-auto p-4">
      <button className="bg-blue-500 text-white p-2 rounded mb-4" onClick={() => router.push('/')}>
        Back
      </button>
      {starship && (
        <div className="border p-4 rounded shadow">
          <h2 className="text-2xl font-bold mb-4">{starship.name}</h2>
          <p>Model: {starship.model}</p>
          <p>Manufacturer: {starship.manufacturer}</p>
          <p>Passengers: {starship.passengers}</p>
          <p>Max Atmosphering Speed: {starship.max_atmosphering_speed}</p>
          <p>Crew: {starship.crew}</p>
          <p>Cargo Capacity: {starship.cargo_capacity}</p>
        </div>
      )}
    </div>
  );
};

