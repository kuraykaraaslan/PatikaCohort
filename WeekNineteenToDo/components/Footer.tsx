import React from 'react';

interface FooterProps {
  todosLeft: number;
  filter: 'all' | 'active' | 'completed';
  setFilter: (filter: 'all' | 'active' | 'completed') => void;
  clearCompleted: () => void;
}

const Footer: React.FC<FooterProps> = ({ todosLeft, filter, setFilter, clearCompleted }) => {
  return (
    <footer className="footer">
      <span className="todo-count">
        {todosLeft} {todosLeft === 1 ? 'item' : 'items'} left
      </span>
      <ul className="filters">
        <li>
          <a
            href="#/"
            className={filter === 'all' ? 'selected' : ''}
            onClick={() => setFilter('all')}
          >
            All
          </a>
        </li>
        <li>
          <a
            href="#/active"
            className={filter === 'active' ? 'selected' : ''}
            onClick={() => setFilter('active')}
          >
            Active
          </a>
        </li>
        <li>
          <a
            href="#/completed"
            className={filter === 'completed' ? 'selected' : ''}
            onClick={() => setFilter('completed')}
          >
            Completed
          </a>
        </li>
      </ul>
      <button className="clear-completed" onClick={clearCompleted} hidden={todosLeft === 0}>
        Clear completed
      </button>
    </footer>
  );
};

export default Footer;
