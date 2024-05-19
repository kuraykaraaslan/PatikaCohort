'use client';
import React, { useState } from 'react';
import Header from '../components/Header';
import TodoList from '../components/TodoList';
import Footer from '../components/Footer';
import { Todo } from '../types';

const initialTodos: Todo[] = [
  { id: '1', text: 'Taste JavaScript', done: true },
  { id: '2', text: 'Code furiously', done: true },
  { id: '3', text: 'Promote Mavo', done: false },
  { id: '4', text: 'Give talks', done: false },
  { id: '5', text: 'Write tutorials', done: true },
  { id: '6', text: 'Have a life!', done: false },
];

const App: React.FC = () => {
  const [todos, setTodos] = useState<Todo[]>(initialTodos);
  const [filter, setFilter] = useState<'all' | 'active' | 'completed'>('all');

  const addTodo = (text: string) => {
    setTodos([...todos, { id: Date.now().toString(), text, done: false }]);
  };

  const toggleTodo = (id: string) => {
    setTodos(todos.map(todo => todo.id === id ? { ...todo, done: !todo.done } : todo));
  };

  const deleteTodo = (id: string) => {
    setTodos(todos.filter(todo => todo.id !== id));
  };

  const clearCompleted = () => {
    setTodos(todos.filter(todo => !todo.done));
  };

  const filteredTodos = todos.filter(todo => {
    if (filter === 'active') return !todo.done;
    if (filter === 'completed') return todo.done;
    return true;
  });

  return (
    <section className="todoapp">
      <Header addTodo={addTodo} />
      <section className="main" hidden={todos.length === 0}>
        <input
          id="toggle-all"
          className="toggle-all"
          type="checkbox"
          checked={todos.every(todo => todo.done)}
          onChange={() => {
            const allDone = todos.every(todo => todo.done);
            setTodos(todos.map(todo => ({ ...todo, done: !allDone })));
          }}
        />
        <label htmlFor="toggle-all">Mark all as complete</label>
        <TodoList todos={filteredTodos} toggleTodo={toggleTodo} deleteTodo={deleteTodo} />
      </section>
      <Footer
        todosLeft={todos.filter(todo => !todo.done).length}
        filter={filter}
        setFilter={setFilter}
        clearCompleted={clearCompleted}
      />
    </section>
  );
};

export default App;
