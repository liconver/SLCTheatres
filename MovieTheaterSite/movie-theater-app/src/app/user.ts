export class User {

    constructor(
        public username: string,
        public password: string,
        public id?: string,
        public email?: string,
        public firstName?: string,
        public lastName?: string
    ) {}
}
