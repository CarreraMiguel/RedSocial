package com.campusdual.SocialMedia;

import com.campusdual.Utils;

import java.util.*;

public class SocialMedia {
    private List<User> currentUsers = new ArrayList<>();
    private Map<User, List<Post>> uploadedPost = new HashMap<>();
    private Map <User, List<Comentaries>> uploadedComentaries = new HashMap<>();
    private User activeUser;

    public Map<User, List<Post>> getUploadedPost() {
        return uploadedPost;
    }

    public void setUploadedPost(Map<User, List<Post>> uploadedPost) {
        this.uploadedPost = uploadedPost;
    }

    public List<User> getCurrentUsers() {
        return currentUsers;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.populateSocialMedia();
        sm.init();
    }

    private void populateSocialMedia() {
        User u1 = new User("miguel");
        User u2 = new User("arturo");
        User u3 = new User("ruben");
        User u4 = new User("pablo");
        /* Post post1 = new PostText("Mi primer post", new Date(),"Uo uo uo uo estoy en la red");
        Post post2 = new PostText("Vacaciones de Verano", new Date(), "De vacaciones en Marbella con los Java Masters");
        Post post3 = new PostVideo("Puesta de Sol", new Date(), 1080, 16  );
        Post post4 = new PostImage ("JavaScripteando", new Date(),"850 x 1200" );
        u1.savePost(post1);
        u2.savePost(post2);
        u3.savePost(post3);
        u4.savePost(post4);
        this.uploadedPost.put(u1, new ArrayList<Post>());
        this.uploadedPost.get(u1).add(post1);
        this.uploadedPost.put(u2, new ArrayList<Post>());
        this.uploadedPost.get(u2).add(post2);
        this.uploadedPost.put(u3, new ArrayList<Post>());
        this.uploadedPost.get(u3).add(post3);
        this.uploadedPost.put(u4, new ArrayList<Post>());
        this.uploadedPost.get(u4).add(post4); */
        this.getCurrentUsers().add(u1);
        this.getCurrentUsers().add(u2);
        this.getCurrentUsers().add(u3);
        this.getCurrentUsers().add(u4);
    }

    private void init() {
        int option;
        do {
            System.out.println("=============================================");
            System.out.println("Bienvenido a la red social ~Java Masters~");
            System.out.println("=============================================");
            System.out.println(" ");
            System.out.println("Pulsa 1 para Registrarte, Pulsa 2 para Iniciar Sesión, Pulsa 0 para salir.");
            option = Utils.integer("Seleccione opción: ");
            System.out.println("==================================================");
            System.out.println(" ");
            switch (option) {
                case 1:
                    this.addUser();
                    break;
                case 2:
                    this.login();
                    break;
                default:
                    break;
            }
        } while (option != 0) ;
        System.out.println("Saliendo de la aplicación");
    }

    private void login() {
        System.out.println("Selecciona el usuario para entrar a la aplicación");
        List<User> users = Utils.showAndSelectFromList(this.currentUsers, false);
        if (!users.isEmpty()){
            this.setActiveUser(users.get(0));
        }
        this.loggedMenu();
    }

    private int loggedMenu() {
        int option;
        do {
            System.out.println("Hola " + this.getActiveUser().getName());
            System.out.println("Pulsa 1 para eliminar un usuario de la Red Social");
            System.out.println("Pulsa 2 para agregar un amigo");
            System.out.println("Pulsa 3 para eliminar un amigo");
            System.out.println("Pulsa 4 para ver tu lista de amigos");
            System.out.println("======================================");
            System.out.println("Pulsa 5 para publicar un Post");
            System.out.println("Pulsa 6 para ver los Post de ~Java Masters~");
            System.out.println("Pulsa 7 para ver tus Post publicados");
            System.out.println("=============================");
            System.out.println("Pulsa 8 para hacer un Comentario");
            System.out.println("Pulsa 9 para ver todos tus Comentarios");
            option = Utils.integer("¿Que vas a hacer hoy?: ");
            switch (option) {
                case 1:
                    removeUser();
                    break;
                //Agregar Amigo
                case 2:
                    this.followFriend();
                    break;
                //Eliminar un amigo
                case 3:
                    this.unfollowFriend();
                    break;
                case 4:
                    this.listFriends();
                    //Comentar un Post
                    break;
                case 5:
                    this.postMenu();
                    break;
                case 6:
                    //Listar Los Post de la Web
                    break;
                case 7:
                    this.listmyPost();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación");
                    break;
                default:
                    break;
           }
        }   while(option != 0);
        return option;
    }
    private int postMenu() {
        int option;
        do {
            System.out.println(" ");
            System.out.println("1. Postear un Texto");
            System.out.println(" ");
            System.out.println("2. Postear una Foto");
            System.out.println(" ");
            System.out.println("3. Postear un Video");
            System.out.println(" ");
            System.out.println("0. Volver al menú anterior");
            System.out.println(" ");
            option = Utils.integer("Elige el tipo de post: ");
            switch (option) {
                case 1:
                    PostText textPost = new PostText();
                    this.activeUser.savePost(textPost);
                    loggedMenu();
                    break;
                case 2:
                    PostImage imagePost = new PostImage();
                    this.activeUser.savePost(imagePost);
                    loggedMenu();
                    //createPostImage();
                    break;
                case 3:
                    PostVideo videoPost = new PostVideo();
                    this.activeUser.savePost(videoPost);
                    loggedMenu();
                    //createPostVideo();
                    break;
                case 0:
                    this.loggedMenu();
                    break;
                default:
                    break;
            }
        } while (option != 0);
        return option;
    }

    private void listFriends() {
        System.out.println(" ");
        System.out.println("Estos son las personas a las que sigues: ");
        Utils.showFromList(this.getActiveUser().getFriends(),false);

//2.- //        for(User u : this.getActiveUser().getFriends()){
//            System.out.println(u);
//        }

       //3.- // List<User> friendList = this.getActiveUser().getFriends();
//        for(int i = 0; i < friendList.size(); i ++){
//            System.out.println((i+1)+".- "+ friendList.get(i));
//        }

    }

    private void unfollowFriend() {
        System.out.println("Estos son los usuarios de la plataforma, slecciona el que quieras seguir: ");
        List<User> userList2 = Utils.showAndSelectFromList(this.getCurrentUsers(), true, false, this.getActiveUser().getFriends());
        if (!userList2.isEmpty()){
            this.getActiveUser().getFriends().remove(userList2.get(0));
        }
    }

    private void followFriend() {
        System.out.println("Estos son los usuarios de la plataforma, selecciona el que quieras seguir: ");
        List<User> userList = Utils.showAndSelectFromList(this.getCurrentUsers(), true, false, this.getActiveUser().getFriends());
        if (!userList.isEmpty()){
            this.getActiveUser().getFriends().add(userList.get(0));
        }
    }



    //METODO PARA VER EL POST DEL ACTIVE USER
    private void listmyPost() {
        System.out.println("======================================");
        System.out.println(this.activeUser.getName());
        Utils.showFromList(this.activeUser.myownPost, true);
    }

     private void listAllPost(){
       //Funcion para Mostrar todos los Post de la Red Social
    }
//        for(User u: this.getCurrentUsers()){
//            System.out.println(u.getName());
//        }
//        String stringuserName = Utils.string("Selecciona el usuario a seguir: ");
//        for(User u: this.getCurrentUsers()){
//           if(u.getName().equals(stringuserName)){
//               this.getActiveUser().getFriends().add(u);
//           }
//        }



//        String username = Utils.string("Escribe el usuario: ");
//        if( username == null) {
//            System.out.println("No te olvides de escribir el nombre del usuario que quieres seguir!");
//            followFriend();
//        }
//        User friend = new User(username);
//        friends.add(friend);

    //Metodo crear Usuarios en la Red Social
        private void addUser() {
            String username = Utils.string("Escribe el usuario:");
            User newUser = new User(username);
            currentUsers.add(newUser);
        }

        //Metodo eliminar Usuario de la red Social
        public void removeUser (){
            //Listar usuarios actualeas
            //Seleccionar el usuario a eliminar
            //Eliminar el usuario de la lista de usuarios
            System.out.println("Introduce el nombre del usuario a eliminar: ");
            List<User> userList = Utils.showAndSelectFromList(this.getCurrentUsers(),false);
            if (!userList.isEmpty()){
                this.getCurrentUsers().remove(userList.get(0));
                if((this.getActiveUser().getFriends()).contains(userList.get(0)) ){
                    this.getActiveUser().getFriends().remove(userList.get(0));
                }
            }
        }
}