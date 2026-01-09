<#import "base.ftl" as ui>
<@ui.mainLayout title="Alerta de Sistema">
    <h3 style="color: #ffc107;">
        Aviso de Segurança:
    </h3>
    <p>Detectamos uma atividade incomum na sua conta:</p>
    <ul>
        <li><strong>Evento:</strong> ${eventDescription}</li>
        <li><strong>Data/Hora:</strong> ${timestamp!"Não Encontrada"}</li>
        <li><strong>Localização:</strong> ${location!"Desconhecida"}</li>
    </ul>
    <p>Caso não reconheça este acesso, recomendamos que altere sua senha imediatamente.</p>
</@ui.mainLayout>