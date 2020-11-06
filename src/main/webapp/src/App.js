import React from 'react';
import {
	BrowserRouter as Router,
	Switch,
	Route,
} from "react-router-dom";

import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

import { Home, NavBar, RegistrationPage, ProfilePage } from './components';

function App() {
	return (
		<Router>

			<NavBar />

			<Switch>
				<Route path='/' exact component={Home} />
				<Route path='/register' component={RegistrationPage} />
				<Route path='/profile' component={ProfilePage} />
			</Switch>

			{/* TODO Footer */}

		</Router>
	);
}

export default App;
