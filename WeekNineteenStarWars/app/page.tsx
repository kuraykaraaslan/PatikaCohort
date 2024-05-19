'use client';
import { useState, useEffect } from 'react';
import StarshipCard from '../components/StarshipCard';
import { useRouter } from 'next/navigation';
import instance from '@/lib/axios';

interface Starship {
  id: number;
  name: string;
  model: string;
  hyperdrive_rating: string;
  url: string;
}

const Home: React.FC = () => {
  const [starships, setStarships] = useState<Starship[]>([]);
  const [searchQuery, setSearchQuery] = useState('');

  const [currentPage, setCurrentPage] = useState(1);
  const [haveNextPage, setHaveNextPage] = useState(false);
  const router = useRouter();

  const searchStarships = () => {

    instance.get('starships', {
      params: {
        search: searchQuery,
      },
    })
      .then((res) => {
        for (let i = 0; i < res.data.results.length; i++) {
          var starship = res.data.results[i];
          starships.push({
            id: i + 2,
            name: starship.name,
            model: starship.model,
            hyperdrive_rating: starship.hyperdrive_rating,
            url: starship.url,
          });
        }
        
      }
      )
      .catch((err) => {
        console.error(err);
      });
  }


useEffect(() => {
  loadByPage(currentPage);
}
  , [currentPage]);

const loadByPage = (page: number) => {
  instance.get(`starships/?page=${page}`)
    .then((res) => {
      for (let i = 0; i < res.data.results.length; i++) {
        var starship = res.data.results[i];
        console.log(starship);
        starships.push({
          id: i + 2,
          name: starship.name,
          model: starship.model,
          hyperdrive_rating: starship.hyperdrive_rating,
          url: starship.url,
        });
      }
      setStarships(starships);

      if (res.data.next) {
        const url = res.data.next;
        const page = url.split('=')[1];
        if (page) {
          setHaveNextPage(true);
        }
      } else {
        setHaveNextPage(false);
      }
    })
    .catch((err) => {
      console.error(err);
    });
}


const showStarshipDetails = (id: number) => {
  router.push(`/starships/${id}`);
};

return (
  <div className="container mx-auto p-4">
    <div className="mb-4">
      <input
        type="text"
        className="border p-2 rounded mr-2"
        placeholder="Search by name or model"
        value={searchQuery}
        onChange={(e) => setSearchQuery(e.target.value)}
      />
      <button className="bg-blue-500 text-white p-2 rounded" onClick={searchStarships}>
        Search
      </button>
    </div>
    <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
      {starships.map((starship) => (
        <StarshipCard key={starship.name} starship={starship} />
      ))}
    </div>
    {haveNextPage && (
      <button className="bg-blue-500 text-white p-2 rounded mt-4" onClick={() => setCurrentPage(currentPage + 1)}>
        Load More
      </button>
    )}
  </div>
);
};

export default Home;
