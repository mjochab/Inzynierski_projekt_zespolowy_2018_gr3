package patron.mains.guis.widgets.menu.builders;

import com.appscharles.libs.fxer.models.MenuItemTreeView;
import com.appscharles.libs.fxer.sneakers.ExceptionDialogThrowSneaker;
import com.appscharles.libs.fxer.switchers.PaneViewSwitcher;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.Pane;
import patron.auth.globals.UserGlobal;
import patron.events.enums.EventType;
import patron.events.factories.EventViewFactory;
import patron.mains.guis.popups.CommonPopup;
import patron.pp.guis.show.PPViewFactory;
import patron.tickets.enums.TicketType;
import patron.tickets.factories.TicketViewFactory;
import patron.users.enums.RoleName;
import patron.users.factories.UserListViewFactory;
import patron.users.services.UserService;

import java.util.ResourceBundle;

/**
 * The type Root menu tree view builder.
 */
public class RootMenuTreeViewBuilder {

    private ResourceBundle resourceBundle;

    private Pane containerPane;

    private RootMenuTreeViewBuilder() {
        // for gimp: 100, 100, -50
    }

    /**
     * Create root menu tree view builder.
     *
     * @param containerPane  the container pane
     * @param resourceBundle the resource bundle
     * @return the root menu tree view builder
     */
    public static RootMenuTreeViewBuilder create(Pane containerPane, ResourceBundle resourceBundle) {
        RootMenuTreeViewBuilder instance = new RootMenuTreeViewBuilder();
        instance.containerPane = containerPane;
        instance.resourceBundle = resourceBundle;
        return instance;

    }

    /**
     * Build tree item.
     *
     * @return the tree item
     */
    public TreeItem<MenuItemTreeView> build() {
        TreeItem<MenuItemTreeView> root = new TreeItem<>();
        TreeItem<MenuItemTreeView> groupTickets = new TreeItem<>(new MenuItemTreeView(this.resourceBundle.getString("view.tree_view.label.tickets"), "/patron/mains/guis/widgets/menu/images/TicketsIcon.png", null));
        TreeItem<MenuItemTreeView> groupManager = new TreeItem<>(new MenuItemTreeView(this.resourceBundle.getString("view.tree_view.label.manager"), "/patron/mains/guis/widgets/menu/images/ManagerIcon.png", null));
        TreeItem<MenuItemTreeView> groupSettings = new TreeItem<>(new MenuItemTreeView(this.resourceBundle.getString("view.tree_view.label.settings"), "/patron/mains/guis/widgets/menu/images/SettingsIcon.png", null));
        groupTickets.setExpanded(true);
        groupManager.setExpanded(true);
        groupSettings.setExpanded(true);
        TreeItem<MenuItemTreeView> itemTicketsFlights = new TreeItem<>(new MenuItemTreeView(this.resourceBundle.getString("view.tree_view.label.flights"), "/patron/mains/guis/widgets/menu/images/AuterIcon.png", () -> {
            ExceptionDialogThrowSneaker.sneaky(() -> {
                PaneViewSwitcher paneViewSwitcher = new PaneViewSwitcher(this.containerPane).enableResize();
                paneViewSwitcher.switchTo(new TicketViewFactory("Bilety na loty", TicketType.FLIGHT).create());
            });
        }));
        TreeItem<MenuItemTreeView> itemTicketsTours = new TreeItem<>(new MenuItemTreeView(this.resourceBundle.getString("view.tree_view.label.tours"), "/patron/mains/guis/widgets/menu/images/AuterIcon.png", () -> {
            ExceptionDialogThrowSneaker.sneaky(() -> {
                PaneViewSwitcher paneViewSwitcher = new PaneViewSwitcher(this.containerPane).enableResize();
                paneViewSwitcher.switchTo(new TicketViewFactory("Bilety na wycieczki", TicketType.TOUR).create());
            });
        }));
        TreeItem<MenuItemTreeView> itemTicketsTurnus = new TreeItem<>(new MenuItemTreeView(this.resourceBundle.getString("view.tree_view.label.stays"), "/patron/mains/guis/widgets/menu/images/AuterIcon.png", () -> {
            ExceptionDialogThrowSneaker.sneaky(() -> {
                PaneViewSwitcher paneViewSwitcher = new PaneViewSwitcher(this.containerPane).enableResize();
                paneViewSwitcher.switchTo(new TicketViewFactory("Bilety na turnus", TicketType.TURNUS).create());
            });
        }));
        TreeItem<MenuItemTreeView> itemFlights = new TreeItem<>(new MenuItemTreeView(this.resourceBundle.getString("view.tree_view.label.flights"), "/patron/mains/guis/widgets/menu/images/FlightsIcon.png", () -> {
            ExceptionDialogThrowSneaker.sneaky(() -> {
                PaneViewSwitcher paneViewSwitcher = new PaneViewSwitcher(this.containerPane).enableResize();
                paneViewSwitcher.switchTo(new EventViewFactory("Zarządzanie lotami", EventType.FLIGHT).create());
            });
        }));
        TreeItem<MenuItemTreeView> itemTours = new TreeItem<>(new MenuItemTreeView(this.resourceBundle.getString("view.tree_view.label.tours"), "/patron/mains/guis/widgets/menu/images/FlightsIcon.png", () -> {
            ExceptionDialogThrowSneaker.sneaky(() -> {
                PaneViewSwitcher paneViewSwitcher = new PaneViewSwitcher(this.containerPane).enableResize();
                paneViewSwitcher.switchTo(new EventViewFactory("Zarządzanie wycieczkami", EventType.TOUR).create());
            });
        }));
        TreeItem<MenuItemTreeView> itemTurnus = new TreeItem<>(new MenuItemTreeView(this.resourceBundle.getString("view.tree_view.label.stays"), "/patron/mains/guis/widgets/menu/images/FlightsIcon.png", () -> {
            ExceptionDialogThrowSneaker.sneaky(() -> {
                PaneViewSwitcher paneViewSwitcher = new PaneViewSwitcher(this.containerPane).enableResize();
                paneViewSwitcher.switchTo(new EventViewFactory("Zarządzanie turnusami", EventType.TURNUS).create());
            });
        }));
        TreeItem<MenuItemTreeView> itemPP = new TreeItem<>(new MenuItemTreeView(this.resourceBundle.getString("view.tree_view.label.pp"), "/patron/mains/guis/widgets/menu/images/UsersIcon.png", () -> {
            ExceptionDialogThrowSneaker.sneaky(() -> {
                CommonPopup.showAndWaitFx(new PPViewFactory());
            });
        }));
        TreeItem<MenuItemTreeView> itemLogs = new TreeItem<>(new MenuItemTreeView(this.resourceBundle.getString("view.tree_view.label.logs"), "/patron/mains/guis/widgets/menu/images/LogsIcon.png", () -> {
            ExceptionDialogThrowSneaker.sneaky(() -> {

            });
        }));
        TreeItem<MenuItemTreeView> itemUsers = new TreeItem<>(new MenuItemTreeView(this.resourceBundle.getString("view.tree_view.label.users"), "/patron/mains/guis/widgets/menu/images/UsersIcon.png", () -> {
            ExceptionDialogThrowSneaker.sneaky(() -> {
                CommonPopup.showAndWaitFx(new UserListViewFactory());
            });
        }));
        if (UserService.hasRole(UserGlobal.getUser(), RoleName.ADMIN, RoleName.AVIATION_COMPANY, RoleName.CLIENT, RoleName.AGENT)) {
            groupTickets.getChildren().add(itemTicketsFlights);
        }
        if (UserService.hasRole(UserGlobal.getUser(), RoleName.ADMIN, RoleName.CLIENT, RoleName.AGENT)) {
            groupTickets.getChildren().add(itemTicketsTours);
            groupTickets.getChildren().add(itemTicketsTurnus);
        }
        if (UserService.hasRole(UserGlobal.getUser(), RoleName.ADMIN, RoleName.AVIATION_COMPANY)) {
            groupManager.getChildren().add(itemFlights);
        }
        if (UserService.hasRole(UserGlobal.getUser(), RoleName.ADMIN, RoleName.TRAVEL_AGENCY)) {
            groupManager.getChildren().add(itemTurnus);
            groupManager.getChildren().add(itemTours);
        }
        groupSettings.getChildren().add(itemUsers);
        if (UserService.hasRole(UserGlobal.getUser(), RoleName.ADMIN,
                RoleName.CLIENT, RoleName.AGENT, RoleName.AVIATION_COMPANY)) {
            root.getChildren().add(groupTickets);
        }
        if (UserService.hasRole(UserGlobal.getUser(), RoleName.ADMIN,
                RoleName.TRAVEL_AGENCY, RoleName.AVIATION_COMPANY)) {
            root.getChildren().add(groupManager);
        }
        if (UserService.hasRole(UserGlobal.getUser(), RoleName.ADMIN, RoleName.AGENT)) {
            root.getChildren().add(itemPP);
        }
        root.getChildren().add(itemLogs);
        if (UserService.hasRole(UserGlobal.getUser(), RoleName.ADMIN)) {
            root.getChildren().add(groupSettings);
        }
        return root;
    }
}
