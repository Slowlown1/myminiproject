# PAGE DE GARDE


<img width="413" height="197" alt="image" src="https://github.com/user-attachments/assets/5db2e379-7c83-47f5-80bf-b898a7366d70" />              <img width="517" height="205" alt="image" src="https://github.com/user-attachments/assets/536bf9bf-4524-4870-b110-af1bcab92c1d" />


                                   Gestion d’un garage automobile (client,véhicule,réparations,factures)
 Réalisé et Présentée par :                                                                                                                                                 
  SAIF Jamila
  
 KHALLOUKI Salma
 
 MRAZGA Khadija 
                                                                                                                                     
                                                                                                               Encadré par:  
                                                                                                                   BADDI  Youssef

# PLAN
     01. Introduction
     02. Problématique & solution
     03. Objectifs du projet 
     04. Fonctionalitées
     05. Les technologies utilisées
     06.L'intégration de la bases de données (MY SQL)
     07. Tester l’application 
     08. Conclusion
# 01 INTRODUCTION
      Dans le secteur de la réparation automobile, la croissance d'une clientèle entraîne inévitablement une 
      complexification exponentielle des tâches administratives et opérationnelles. Les garagistes, dont le 
      cœur de métier est avant tout technique,se retrouvent souvent submergés par :
      La multiplication des dossiers papier : Fiches clients éparpillées, historiques de véhicules incomplets,
      factures mal archivées.
      La redondance des saisies : Recopier les informations du client sur le devis, puis sur la facture, puis 
      sur le bon de commande des pièces.Les erreurs humaines : Calculs manuels erronés, oublis de suivi, confusion 
      entre véhicules similaires.
      L'inefficacité temporelle : Perdre un temps considérable à rechercher un historique de réparation ou à
      constituer un devis détaillé.
      Cette gestion manuelle fragmentée nuit à la fois à la productivité de l'atelier, à la qualité du service 
      client et à la fiabilité de la comptabilité. Il existe donc un besoin critique de rationalisation et de
      centralisation des données.
# 02 PROBLEMATIQUE ET SOLUTION
   <img width="86" height="86" alt="image" src="https://github.com/user-attachments/assets/be9218d1-ac54-4e83-b6d8-3e41a63a9d24" /> 
   # PROBLÉMATIQUE 
   
   + Multiplicité des supports : Fiches clients papier, carnets de rendez-vous, bons de travail, factures carbone, commandes fournisseurs
      - chaque document vit séparément.
   + Absence de centralisation : Aucun point unique de vérité. L'historique d'un véhicule peut être réparti entre le classeur des clients, 
     le cahier de l'atelier et les archives comptables.
   + Redondance des données : Les mêmes informations (coordonnées client, caractéristiques véhicule) sont recopiées manuellement sur 4 à 5 documents
    différents, multipliant les risques d'erreur.
   + Procédures non standardisées : Chaque employé peut avoir sa propre méthode pour enregistrer une réparation ou établir un devis.
   + Chaînes d'information rompues : La réception note le problème, le mécanicien écrit son diagnostic sur un papier volant, le gérant calcule le prix
      sur un coin de table.
   + Manque de traçabilité : Impossible de retracer précisément qui a fait quoi, quand et avec quelles instructions.
   + Planification aléatoire : Affectation manuelle des véhicules aux mécaniciens sans visibilité sur les compétences requises ou la charge de travail.
   + Suivi en temps réel impossible : Le gérant doit physiquement faire le tour de l'atelier pour connaître l'état d'avancement des réparations.
    
# SOLUTION
    Développement d’une application Java en mode console
    
    Utilisation de structures en mémoire pour gérer les données
    
    Organisation claire du code grâce à une architecture modulaire
    
    Application des principes de la programmation orientée objet (POO) 
    
    pour une meilleure structuration du code

    Séparation des responsabilités entre les classes (Client, Véhicule, Réparation, Facture)

    Automatisation du calcul des factures afin de réduire les erreurs humaines

    Centralisation des données pour éviter la duplication et la perte d’informations

    Mise en place d’une navigation claire à travers un menu interactif en mode console

    Facilitation de la maintenance et de l’évolution future du projet

    Possibilité d’intégrer ultérieurement une base de données pour la persistance des données

    Préparation du projet pour une évolution vers une interface graphique
    
# 03 FONCTIONNALITÉ 
Gestion des clients:

      Ajouter un client

      Afficher la liste des clients

      Consulter les informations d’un client

 Gestion des véhicules :

      Ajouter un véhicule à un client

      Gérer les informations du véhicule (marque, modèle, immatriculation)

Gestion des réparations :

     Enregistrer une réparation

     Définir la date, la description et le coût de la réparation

 Gestion des factures :

     Calculer automatiquement le total des réparations

     Générer et afficher une facture détaillée

Mode d’exécution :

     Application entièrement exécutée en mode console

    
 # 04 OBJECTIFS DU PROJETÉ  
    Développer une application Java simple permettant une gestion efficace
    
    et organisée d’un garage automobile.
    
    Gérer les clients du garage .
    
    Associer des véhicules aux clients .
    
    Enregistrer les réparations effectuées .
    
    Générer une facture à partir des réparations .
    
    Appliquer les concepts de la programmation orientée objet en Java
    
# 05 LES TECHNOLOGIES UTILISÉES 
    Langage : Java                       
    Programmation orientée objet
    Mode console
  <img width="1107" height="384" alt="image" src="https://github.com/user-attachments/assets/81fff68e-9df0-4ff2-85cc-e337db5ba59d" />
      


    Gestion des dépendances.
    Structure standard du projet Maven
  <img width="446" height="112" alt="image" src="https://github.com/user-attachments/assets/65d6dcbe-8439-4de8-b6b9-23646795b830" />

     =>Structure Maven du Projet
     src/main/java : Code source src/main/
     pom.xml
     src/main/java/com/example/garage
     target
  <img width="524" height="375" alt="image" src="https://github.com/user-attachments/assets/80d3f629-61fc-493b-8aca-94fa922224a0" />

# 06 L'INTEGRATION DE LA BASES DE DONNÉES (MY SQL)

   Grâce à cette intégration :

Les informations des clients, véhicules, réparations et factures sont désormais persistantes

Les données restent disponibles même après la fermeture et le redémarrage de l’application

Le système devient plus proche d’une application professionnelle réelle

Cette évolution a permis de séparer clairement :

la logique métier de l’application

la gestion des données à travers la base de données

L’intégration de MySQL constitue ainsi une étape importante dans l’évolution du projet

et ouvre la voie à de futures améliorations, telles que :

la gestion multi-utilisateurs

l’ajout de fonctionnalités avancées

ou la migration vers une interface graphique


# 07 TESTER D'APPLICATION
  Ce test valide le bon fonctionnement du mécanisme de navigation entre les classes principales de l’application.
  
  <img width="1799" height="475" alt="image" src="https://github.com/user-attachments/assets/c353b016-7ca2-4280-be95-793be86360c7" />

    Enregistrement d’un client.
  <img width="1416" height="544" alt="image" src="https://github.com/user-attachments/assets/d3abb1f9-2555-40ca-a6c9-a097eb6a44c2" />

    Enregistrement d’une voiture.
   <img width="1804" height="317" alt="image" src="https://github.com/user-attachments/assets/7c9e3742-63cb-49b6-b667-2a9685f69a88" />

    Affichage des données clients depuis la base de données.
  <img width="1846" height="360" alt="image" src="https://github.com/user-attachments/assets/b08f7ee6-7be1-4823-8523-1686811f7de6" />

# 08 CONCLUSION
   Pour conclure, nous avons développé une application robuste et complète qui répond à tous les besoins d'un garage
   Nous avons non seulement créé l'intégralité du cycle (Client à Facture), mais nous avons aussi géré la complexité du 
   chargement en cascade, prouvant la fiabilité de notre accès aux données. Ce projet est solide, il est basé sur de bonnes pratiques
   logicielles (Pattern Repository), et il est prêt à être modernisé vers une interface graphique.
   




    






