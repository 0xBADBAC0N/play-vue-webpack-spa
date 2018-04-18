# Play Framework + Vue.js starter

This is a modern Play Framework + Vue.js (v2) + bootstrap-vue + vue-router boilerplate that uses Webpack
to load front-end modules and provide **hot reloading**.

In production mode, it has proper 
long-term caching, **minified and gzip-compressed css and js bundles**

It supports SASS and includes Bootstrap-vue(v2) by default. (Bootstrap may easily be 
removed or replaced though).

It works out-of-the-box.

## How to use
```bash
git clone git@github.com:0xBADBAC0N/play-vue-webpack-spa.git
```

#### Requirements
* sbt
* npm

#### Set up database
```bash
-- Set up a new user for our project and login
mysql -u root -p -e "GRANT ALL PRIVILEGES ON *.* TO 'playuser'@'127.0.0.1' IDENTIFIED BY 'CHANGEME';"
```

```bash
-- login

```

```bash
-- Set up database
create database if not exists playdb;
use playdb;

-- Set up user table
create table if not exists user (
	id BIGINT UNSIGNED AUTO_INCREMENT, 
	created_at timestamp default CURRENT_TIMESTAMP(),
	updated_at timestamp default CURRENT_TIMESTAMP(),
	display_name varchar(100) not null,
	email varchar(190) not null,
	session varchar(36),
	password varchar(250) not null,
	PRIMARY KEY (`id`),
	UNIQUE KEY `email` (`email`)
);

-- Set up the items table
CREATE TABLE IF NOT EXISTS items (
	id BIGINT UNSIGNED AUTO_INCREMENT, 
	created_at timestamp default current_timestamp,
	updated_at timestamp not null,
	set_json MEDIUMTEXT NOT NULL,
	title varchar(100) not null,
	desciption varchar(255) not null,
	created_from BIGINT UNSIGNED not null,
	PRIMARY KEY  (`id`),
	FOREIGN KEY (created_from) REFERENCES user(id)
);
```

##### Test
```bash
-- Create example user
INSERT INTO user (display_name, email, password)
VALUES ('Demo User', 'demouser@gmail.com', SHA2('demo', 512));

-- Create demo set
INSERT INTO items (set_json, title, desciption, created_from)
VALUES ('{
  "imgs":[
    "https://www.payless.com/on/demandware.static/-/Sites-payless-catalog/default/dw3f92e00f/images/hi-res/173951_6_1400x1400.jpg",
    "https://static.highsnobiety.com/wp-content/uploads/2018/01/16235640/2-chainz-versace-sneaker-exclusive-look-000.jpg",
    "https://media.glamour.com/photos/56964eb916d0dc3747efa816/master/pass/fashion-2014-08-26-kenzo-tiger-eye-print-sneakers-main.jpg"
    ]
  
}
', 'Fancy Title', 'Some random text', 1);

-- check content
select count(*) from user;
select count(*) from items;

-- clear tables
SET FOREIGN_KEY_CHECKS = 0;
truncate table items;
truncate table user;
SET FOREIGN_KEY_CHECKS = 1;
```

#### Install all dependencies

```bash
make update
```

### Developement mode
Run the project
> You also can use `sbt ~run`

```bash
make run-dev
```
This boilerplate uses Webpack-dev-server to provide hot-reloading during development.

### Production mode
> This will also trigger the front-end build.
To start the project in production mode without hot-reload and compressed(gzip) page use
```bash
make run-prod
```

## General information
The front-end code entry point is located in `front/app.js`. This is where you can import your modules
and declare your Vue components.

SASS stylesheets are located in the `front/sass` folder.

The main stylesheet is `front/sass/style.scss`. It's imported by default.

Vue single-file components are located in `front/src/components`.

The Play application is in the `app` folder. The `FrontController` is responsible for
serving the index page, with dev or production bundles depending on the current environment.

#### Long-term caching

Production bundles have a unique hash in their name, allowing long-term caching without any
risk of keeping an old build in the browser's cache.

The `lib/WebpackBuildFile` object is responsible for determining the full 
name of the CSS and JS bundles.

## Configuration

### conf/frontend.conf

#### webpack.port
Allows you to change the port Webpack-dev-server is running on. (default 8080)

## Contribute

Contribution are welcome if you know how to improve this project.
